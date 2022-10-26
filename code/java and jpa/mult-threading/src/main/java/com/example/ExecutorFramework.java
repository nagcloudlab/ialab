package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {
    public static void main(String[] args) {

        Runnable task = ()->{
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+" hello");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName+" bye");
        };

        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for(int i=0; i<10;i++){
            executorService.submit(task);
        }

        executorService.shutdown();

    }
}
