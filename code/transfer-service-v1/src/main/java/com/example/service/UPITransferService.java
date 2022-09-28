package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;

/**
 * author : service-team
 */

public class UPITransferService implements TransferService {

    private static final Logger LOGGER=Logger.getLogger("ts"); // singleton


    private AccountRepository accountRepository; // dependency

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        LOGGER.debug("UPITransferService instance created");
    }

    // per sec --> 10k
    @Override
    public void transfer(double amount, String source, String destination) {

        LOGGER.info("Transfer initiated..");


        // Load source & destination account details
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        // update source & destination accounts
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);

        LOGGER.info("transfer completed.");
    }

}
