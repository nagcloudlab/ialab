package com.example;

import java.util.Scanner;

/**
 * process
 * <p>
 * - computation
 * - io
 */

public class App {
    public static void main(String[] args) {

        Runnable ioTask = () -> {
            io();
        };

        Runnable computationTask = () -> {
            computation();
        };

        Thread thread1 = new Thread(ioTask, "io");
        Thread thread2 = new Thread(computationTask, "computation");

        thread1.start(); // new-stack
        thread2.start();

    }

    private static void io() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " on IO");
        // read / write on stdin,file,db,nw
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your Name");
        String name = in.nextLine();
        System.out.println("hello " + name);
        System.out.println(threadName + " finished IO");
    }

    private static void computation() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " on computation");
        while (true) {
        }
    }
}
