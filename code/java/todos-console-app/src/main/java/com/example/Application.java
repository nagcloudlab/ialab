package com.example;

import com.example.service.TodoFilter;
import com.example.service.TodosService;

public class Application {
    public static void main(String[] args) {

        TodosService service = new TodosService();
        service.addTodo("learn jdbc");


    }
}
