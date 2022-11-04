package com.example.web;

import com.example.entity.Transaction;
import com.example.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transaction-history")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    @GetMapping
    public String getAll(Model model) {
        Iterable<Transaction> transactions=transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "transactions-grid";
    }

}
