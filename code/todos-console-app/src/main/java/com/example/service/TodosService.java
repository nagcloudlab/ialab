package com.example.service;

import com.example.model.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodosService {

    private static Long nextId;

    public void addTodo(String newTitle) {
        nextId++; // increment
        Todo todo = new Todo();
        todo.setId(String.valueOf(nextId));
        todo.setTitle(newTitle);
        todo.setCompleted(false);

    }

    public void deleteTodo(String id) {
        //TODO Auto-generated method stub
    }

    public void updateTodo(String id, String newTitle) {
        //TODO Auto-generated method stub
    }

    public void completeTodo(String id) {
        //TODO Auto-generated method stub
    }

    public void completeAllTodos() {
        //TODO Auto-generated method stub
    }

    public void clearCompletedTodos() {
        //TODO Auto-generated method stub
    }

    public List<Todo> getTodos(TodoFilter filter) {
        return List.of(new Todo())
                .stream()
                .filter(todo -> {
                    if (filter.equals(TodoFilter.COMPLETED))
                        return todo.isCompleted();
                    else if (filter.equals(TodoFilter.ACTIVE))
                        return !todo.isCompleted();
                    return true;
                })
                .collect(Collectors.toList());
    }
}
