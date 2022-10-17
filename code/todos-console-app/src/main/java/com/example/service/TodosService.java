package com.example.service;

import com.example.entity.Todo;
import com.example.entity.TodoType;
import com.example.entity.User;
import com.example.repository.TodosRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TodosService {

    private int loggedUserId=2; // e.g Tom

    TodosRepository todosRepository=new TodosRepository();

    public void addTodo(String newTitle) {
        Todo todo = new Todo();
        todo.setTitle(newTitle);
        todo.setCompleted(false);
        todo.setType(TodoType.OFFICE);
        User user = new User();
        user.setId(loggedUserId);
        todo.setUser(user);
        todosRepository.save(todo);
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
