package com.example.service;

import com.example.entity.Todo;
import com.example.repository.TodosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TodosService {

    private final TodosRepository todosRepository;

    public void addTodo(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todosRepository.save(todo);
    }

}
