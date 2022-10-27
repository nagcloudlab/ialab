package com.example;

class Counter {

    private long count = 0;
    private static Object lock=new Object();
    public  void increment() {
       synchronized(lock){
            count += 1;
        }
    }

    public long getCount() {
        return count;
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable countTask = () -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(countTask);
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println(counter.getCount()); // 10000


    }
}
