package com.example;

import com.example.service.TodoFilter;
import com.example.service.TodosService;

public class Application {
    public static void main(String[] args) {

        TodosService service = new TodosService();

        service.addTodo("item-1");
        service.addTodo("item-2");
        service.addTodo("item-3");

        service.updateTodo("1", "item-one");
        service.updateTodo("2", "item-two");

        service.deleteTodo("1");

        service.completeTodo("2");

        service.completeAllTodos();

        service.getTodos(TodoFilter.ACTIVE).forEach(todo -> System.out.println(todo));


    }
}
