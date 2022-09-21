package com.example.service;

import com.example.model.Account;
import com.example.repository.JdbcAccountRepository;

/**
 * author : service-team
 */

public class UPITransferService {

    public UPITransferService(){
        System.out.println("UPITransferService instance created");
    }

    public void transfer(double amount, String source, String destination) {

        System.out.println("Transfer initiated..");

        JdbcAccountRepository accountRepository = new JdbcAccountRepository();

        // Load source & destination account details
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        // update source & destination accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);

        System.out.println("transfer completed.");
    }

}
