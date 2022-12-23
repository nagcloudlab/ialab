package com.example.api;

import java.util.List;
import java.util.stream.Collectors;

import com.example.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.dto.TodoCreateDto;
import com.example.dto.TodoResponseDto;
import com.example.entity.Todo;
import com.example.entity.User;
import com.example.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class TodoController {

    public final TodoRepository todoRepository;
    public final UserRepository userRepository;

    @PostMapping(value = "/api/todos", consumes = { "application/json" })
    public ResponseEntity<?> postTodo(@RequestBody TodoCreateDto todoCreateDto) {

        Todo todo = new Todo();
        todo.setTitle(todoCreateDto.getTitle());

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        User userEntity=userRepository.findByUsername(user.getUsername());
        todo.setUser(userEntity);

        todo = todoRepository.save(todo);

        TodoResponseDto todoResponseDto = new TodoResponseDto();
        todoResponseDto.setId(todo.getId());
        todoResponseDto.setTitle(todo.getTitle());
        todoResponseDto.setCompleted(todo.isCompleted());

        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponseDto);

    }

    @GetMapping(value = "/api/todos")
    public ResponseEntity<?> getAll() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        User userEntity=userRepository.findByUsername(user.getUsername());

        List<Todo> todos = todoRepository.findByUserId(userEntity.getId());
        List<TodoResponseDto> todoResponseDtos = todos
                .stream()
                .map(todo -> new TodoResponseDto(todo.getId(), todo.getTitle(), todo.isCompleted()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(todoResponseDtos);
    }

}
