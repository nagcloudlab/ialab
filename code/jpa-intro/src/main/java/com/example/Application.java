package com.example;


import com.example.repository.JpaTodoRepository;

public class Application {
    public static void main(String[] args) {

        JpaTodoRepository jpaTodoRepository = new JpaTodoRepository();
        jpaTodoRepository.findAll()
                .forEach(todo->{
                    System.out.println(todo.getTitle()+"\t"+todo.getUser().getName());
                });


    }
}
