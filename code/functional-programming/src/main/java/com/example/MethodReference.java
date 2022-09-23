package com.example;

import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {

//        long millis=System.currentTimeMillis();
//        System.out.println(millis);

//        LongSupplier longSupplier=()->{
//            return System.currentTimeMillis();
//        };
//
        // - or

        LongSupplier longSupplier=System::currentTimeMillis;

        long millis=longSupplier.getAsLong();
        System.out.println(millis);


        //-----------------------------------------------------------

    }
}
