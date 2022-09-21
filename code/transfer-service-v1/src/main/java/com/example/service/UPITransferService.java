package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;

/**
 * author : service-team
 */

public class UPITransferService implements TransferService {

    private AccountRepository accountRepository; // dependency

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        System.out.println("UPITransferService instance created");
    }

    // per sec --> 10k
    @Override
    public void transfer(double amount, String source, String destination) {

        System.out.println("Transfer initiated..");


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
