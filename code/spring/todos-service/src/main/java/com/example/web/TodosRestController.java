package com.example.web;

import com.example.dto.TodoRequestDto;
import com.example.entity.Todo;
import com.example.entity.TodoType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TodosRestController {

    private static Map<Integer, Todo> todos = new HashMap<>();

    static {
        todos.put(1, new Todo(1, "Learn Spring MVC", false, TodoType.OFFICE));
        todos.put(2, new Todo(2, "Learn Java", false, TodoType.OFFICE));
        todos.put(3, new Todo(3, "Learn React", false, TodoType.OFFICE));
        todos.put(4, new Todo(4, "Learn Microservices", false, TodoType.OFFICE));
        todos.put(5, new Todo(5, "get rice bag", false, TodoType.HOME));
    }

    // Read

    @GetMapping(
            value = "/api/v1/todos",
            produces = {"application/json"}
    )
    public /*@ResponseBody*/ ResponseEntity<?> getAllTodos(
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit
    ) {
        List<Todo> responseTodos = todos.values().stream().limit(limit).toList();
        return ResponseEntity.ok(responseTodos);
    }

    @GetMapping(
            value = "/api/v1/todos",
            produces = {"application/json"},
            params = {"type"}
    )
    public /*@ResponseBody*/ ResponseEntity<?> getTodosByType(
            @RequestParam(name = "type", required = true) String type
    ) {
        List<Todo> responseTodos = todos.values()
                .stream()
                .filter(todo -> todo.getTodoType().equals(TodoType.valueOf(type)))
                .toList();
        return ResponseEntity.ok(responseTodos);
    }

    @GetMapping(
            value = "/api/v1/todos/{todoId}",
            produces = {"application/json"}
    )
    public /*@ResponseBody*/ ResponseEntity<?> getTodo(
            @PathVariable(name = "todoId", required = true) int todoId
    ) {
        List<Todo> responseTodos = todos.values()
                .stream()
                .filter(todo -> todo.getId() == todoId)
                .toList();
        if (responseTodos.size() != 0)
            return ResponseEntity.ok(responseTodos);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @RequestMapping(
            method = RequestMethod.HEAD,
            value = "/api/v1/todos/{todoId}"
    )
    public /*@ResponseBody*/ ResponseEntity<?> getTodoHeader(
            @PathVariable(name = "todoId", required = true) int todoId
    ) {
        // get details ( e.g size, last-modified, etc ) of resources
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Length", "100");
        responseHeaders.set("Last-Modified", LocalDateTime.now().toString());
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(null);
    }


    //Write
    @PostMapping(
            value = "/api/v1/todos",
            consumes = {
                    "application/json"
            }
    )
    public /*@ResponseBody*/ ResponseEntity<?> addTodo(
//            @RequestParam(value = "title", required = true) String title,
//            @RequestParam(value = "type", required = true) String type
            @RequestBody TodoRequestDto todoRequestDto
    ) {
        int nextId = todos.values().size() + 1;
        Todo todo = new Todo(nextId, todoRequestDto.getTitle(), false, TodoType.valueOf(todoRequestDto.getType().toUpperCase()));
        todos.put(todo.getId(), todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @PutMapping(
            value = "/api/v1/todos/{id}",
            consumes = {
                    "application/json"
            }
    )
    public /*@ResponseBody*/ ResponseEntity<?> createOrUpdateTodo(
            @RequestBody TodoRequestDto todoRequestDto,
            @PathVariable(name = "id", required = true) int id
    ) {
        if (todos.containsKey(id)) {
            Todo todo = todos.get(id);
            todo.setTitle(todoRequestDto.getTitle());
            return ResponseEntity.status(HttpStatus.OK).body(todo);
        } else {
            //
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
    }

    @DeleteMapping(
            value = "/api/v1/todos/{id}"
    )
    public /*@ResponseBody*/ ResponseEntity<?> createOrUpdateTodo(
            @PathVariable(name = "id", required = true) int id
    ) {
        if (todos.containsKey(id)) {
            Todo todo = todos.get(id);
            todos.remove(id);
            return ResponseEntity.status(HttpStatus.OK).body(todo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}