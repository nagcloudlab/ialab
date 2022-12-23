package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Ex {

    public static void main(String[] args) {

        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("Hello");
        strings1.add("World");

        LinkedList<String> strings2 = new LinkedList<>();
        strings2.add("Hello");
        strings2.add("World");

        org.example.util.LinkedList<String> strings3=new org.example.util.LinkedList<>();
        strings3.add("Hello");
        strings3.add("World");

        //--------------------------------------------------------------------------------

        for (String string : strings1){}
        for (String string : strings2){}

//        Iterator<String> iterator=strings3.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (String string : strings3){
            System.out.println(string);
        }

        //--------------------------------------------------------------------------------



    }

}
