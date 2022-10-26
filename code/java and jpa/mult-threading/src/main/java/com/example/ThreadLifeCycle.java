package com.example;

public class ThreadLifeCycle {
    public static void main(String[] args) {

        Runnable task=()->{
            // RUNNABLE
            String threadName= Thread.currentThread().getName();
            for(int i=0; i<500;i++){
                System.out.println(threadName+" -> "+i);
                // TIMED_WAITING,WAIT,BLOCKED
            }
            // DEAD
        };

        Thread thread=new Thread(task,"T1"); // NEW
        Thread thread2=new Thread(task,"T2");
        Thread thread3=new Thread(task,"T3");

        thread.start(); // NEW - READY-TO-RUN
        thread2.start();
        thread3.start();



    }
}
