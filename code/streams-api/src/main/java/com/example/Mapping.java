package com.example;

import com.model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths =
                words.stream()
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println(wordLengths);


        //--------------------------------------------------------------

        String[] m = new String[]{
                "idly,vada,poori,rice",
                "rice,chapathi,chicken",
                "biryani,chicken,rice"
        };

        // find Unique menu items & display in console





    }

}
