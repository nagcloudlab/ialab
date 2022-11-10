package com.example;


import com.example.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListColln_Ex {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(2011, 100.00);
        Transaction transaction2 = new Transaction(2012, 300.00);
        Transaction transaction3 = new Transaction(2011, 400.00);
        Transaction transaction4 = new Transaction(2022, 200.00);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

//        // Local Inner class
//        class ByAmount implements Comparator<Transaction> {
//            @Override
//            public int compare(Transaction o1, Transaction o2) {
//                return Double.compare(o1.getAmount(), o2.getAmount());
//            }
//        }

//        // Local Anonymous Inner class
//        Comparator<Transaction> byAmountComparator = new Comparator<Transaction>() {
//            @Override
//            public int compare(Transaction o1, Transaction o2) {
//                return Double.compare(o1.getAmount(), o2.getAmount());
//            }
//        };


        // From Java-8,

        // Labmda Expression a.k.a  Function


//        Comparator<Transaction> byAmountComparator = ( o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount());

        Collections.sort(transactions, (o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount()));


        display(transactions);


    }

    private static void display(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
