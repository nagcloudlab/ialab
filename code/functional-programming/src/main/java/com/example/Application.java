package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(100, "Red"),
                new Apple(120, "Green"),
                new Apple(150, "Red"));


        List<Apple> greenAppleList = filterApples(inventory, "green",0);
        System.out.println(greenAppleList);

        List<Apple> appleList = filterApples(inventory, null,150);
        System.out.println(appleList);


    }

    // imperative style  : solve any problem step-step
    /*

        intention & implementation mixed together

     */


    private static List<Apple> filterApples(List<Apple> inventory, String color,int weight) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : inventory) {
            if(color!=null) {
                if (apple.getColor().equalsIgnoreCase(color))
                    filtered.add(apple);
            }
            if(weight>0){
                if (apple.getWeight()==weight)
                    filtered.add(apple);
            }
        }
        return filtered;
    }


}
