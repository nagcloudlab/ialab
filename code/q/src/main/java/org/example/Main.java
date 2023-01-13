package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(1);
        executorService.schedule(()->{

            System.out.println("after 15s");

        },15, TimeUnit.SECONDS);



    }
}