package com.example.service;

import com.example.entity.Transaction;
import com.example.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getTransactionsByAccount(String number) {
        return transactionRepository.findByAccount(number);
    }


}
