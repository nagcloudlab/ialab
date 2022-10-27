package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTask {
    public static void main(String[] args) {

        Callable<List<String>> callable = () -> {
            List<String> list = new ArrayList<String>();
            FileReader fr = new FileReader("c:/menu.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            fr.close();
            return list;
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<String>> future = executorService.submit(callable);
        //...
        try {
            List<String> list = future.get();
            list.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
