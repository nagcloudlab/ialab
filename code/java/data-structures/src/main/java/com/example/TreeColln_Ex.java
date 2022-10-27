package com.example;

import com.example.model.Transaction;

import java.util.Set;
import java.util.TreeSet;

public class TreeColln_Ex {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(2011, 100.00);
        Transaction transaction2 = new Transaction(2012, 300.00);
        Transaction transaction3 = new Transaction(2011, 400.00);
        Transaction transaction4 = new Transaction(2022, 200.00);

        Set<Transaction> transactions=new TreeSet<>((t1,t2)->Double.compare(t1.getAmount(),t2.getAmount()));
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        for(Transaction t:transactions){
            System.out.println(t);
        }


    }
}
