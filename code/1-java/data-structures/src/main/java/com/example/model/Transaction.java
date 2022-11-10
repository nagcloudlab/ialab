package com.example.model;

public class Transaction implements Comparable<Transaction> {

    private int year;
    private double amount;

    public Transaction(int year, double amount) {
        this.year = year;
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public int compareTo(Transaction o) {
        return Integer.compare(this.year, o.getYear());
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "year=" + year +
                ", amount=" + amount +
                '}';
    }
}
