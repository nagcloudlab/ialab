package com.example.service;

import com.example.entity.Transaction;

import java.util.List;

public interface TransactionHistoryService {

    List<Transaction> getTransactionsByAccount(String number);

}
