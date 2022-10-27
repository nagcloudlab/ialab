package com.example;

public class Producer_Consumer_Ex {
    static Object lock = new Object();
    static String next = "odd";

    public static void main(String[] args) {

        Runnable oddTask = () -> {
            for (int i = 1; i < 100; i++) {
                synchronized (lock) {
                    if (!next.equals("odd")) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i % 2 != 0) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                        next = "even";
                        lock.notify();
                    }
                }
            }
        };
        Runnable evenTask = () -> {
            for (int i = 1; i < 100; i++) {
                synchronized (lock) {
                    if (!next.equals("even")) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i % 2 == 0) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                        next = "odd";
                        lock.notify();
                    }
                }
            }
        };

        Thread oddThread = new Thread(oddTask,"ODD");
        Thread evenThread = new Thread(evenTask,"EVEN");

        oddThread.start();
        evenThread.start();

    }
}
