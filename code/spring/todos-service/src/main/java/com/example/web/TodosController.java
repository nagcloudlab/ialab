package com.example.web;

import com.example.entity.Todo;
import com.example.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TodosController {

    private final TodoRepository todoRepository;

    @GetMapping("/todos")
    public String getTodos(Map<String, Iterable<Todo>> map) {
        Iterable<Todo> todos = todoRepository.findAll();
        map.put("todos", todos);
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
        Todo newTodo = new Todo(title);
        todoRepository.save(newTodo);
        return "redirect:/todos";
    }

}
