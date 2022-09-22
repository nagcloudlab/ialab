package com.example;

import com.example.model.Apple;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(100, "Red"),
                new Apple(120, "Green"),
                new Apple(150, "Red"));


    }
}
