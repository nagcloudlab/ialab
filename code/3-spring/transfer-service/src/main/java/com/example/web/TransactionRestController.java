package com.example.web;

import com.example.entity.Transaction;
import com.example.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction-history")
public class TransactionRestController {

    private final TransactionRepository transactionRepository;

    @GetMapping
    public Iterable<Transaction> getAll() {
     return transactionRepository.findAll();
    }

}
