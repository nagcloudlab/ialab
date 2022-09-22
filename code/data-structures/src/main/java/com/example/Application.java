package com.example;

import java.util.Iterator;
import java.util.LinkedList;

public class Application {

    public static void main(String[] args) {

        //LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> list=new LinkedList<>();
        list.add("Nag");
        list.add("Indu");
        list.add("Riya");
        list.add("Diya");

        //....

        // collection + iteration logic = iterable
        for (String member : list) {
            System.out.println(member);
        }


    }

}
