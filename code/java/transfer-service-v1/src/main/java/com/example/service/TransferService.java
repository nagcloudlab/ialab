package com.example.service;

public interface TransferService {
    // per sec --> 10k
    void transfer(double amount, String source, String destination);
}
