package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.List;

interface Predicate {
    boolean test(Apple apple);
}

/*

    why we need functional programming ?

    reason: to write compact / concise code

 */

public class Why_We_Need_FP {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(100, "red"),
                new Apple(120, "green"),
                new Apple(150, "red"));

        //A. Local Inner class
//        class GreenApplesPredicate implements Predicate {
//            public boolean test(Apple apple) {
//                return apple.getColor().equals("green");
//            }
//        }
//        B. Anonymous Inner class
//        Predicate greenApplesPredicate = new Predicate() {
//            public boolean test(Apple apple) {
//                return apple.getColor().equals("green");
//            }
//        };

//        C. Labmda Expression a.k.a function

        System.out.println(
                filterApples(inventory, apple -> apple.getColor().equals("green"))
        );
        System.out.println(
                filterApples(inventory, apple -> apple.getColor().equals("red"))
        );
        System.out.println(
                filterApples(inventory, apple -> apple.getWeight() == 150)
        );


    }

    private static List<Apple> filterApples(List<Apple> inventory, Predicate predicate) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                filtered.add(apple);
            }
        }
        return filtered;
    }


}
