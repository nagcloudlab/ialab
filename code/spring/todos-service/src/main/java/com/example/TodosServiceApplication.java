package com.example;

import com.example.service.TodosService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TodosServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(TodosServiceApplication.class, args);

        TodosService todosService = applicationContext.getBean(TodosService.class);
        todosService.addTodo("Learn ??");
    }

}
