package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_vs_LinkedList {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        compare(arrayList);
        compare(linkedList);

    }

    public static void compare(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
