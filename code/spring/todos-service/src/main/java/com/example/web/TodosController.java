package com.example.web;

import com.example.entity.Todo;
import com.example.entity.User;
import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TodosController {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @GetMapping("/todos")
    public String getTodos(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUsername());
        User user = userRepository.findByEmail(userDetails.getUsername());
        Iterable<Todo> todos = todoRepository.findByUser(user.getId());
        model.addAttribute("todos", todos);
        return "todos";
    }

    @GetMapping("/delete-todo")
    public String deleteTdo(
            @RequestParam int id
    ) {
        System.out.println(id);
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @PostMapping("/new-todo")
    public String newTodo(
            @RequestParam String title
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByEmail(userDetails.getUsername());
        Todo newTodo = new Todo(title);
        newTodo.setUser(user);
        todoRepository.save(newTodo);
        return "redirect:/todos";
    }

}
