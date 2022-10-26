package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UPITransferService implements TransferService {

    private static final Logger log = LoggerFactory.getLogger(UPITransferService.class);
    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        log.info("UPITransferService component created");
    }

    public void transfer(double amount, String source, String destination) {
        log.info("Transfer initiated");
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);
        log.info("Transfer completed");
    }
}
