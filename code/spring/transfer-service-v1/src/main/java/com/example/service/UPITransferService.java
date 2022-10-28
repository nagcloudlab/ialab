package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("transferService")
public class UPITransferService implements TransferService {

   @Value("${daily.limit:10}")
   private int dailyLimit;

    private static final Logger log = LoggerFactory.getLogger(UPITransferService.class);
    private AccountRepository accountRepository;

    @Autowired
    public UPITransferService(@Qualifier("jdbcAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        log.info("UPITransferService component created");
    }

    public void transfer(double amount, String source, String destination) {
        log.info("Transfer initiated");
        System.out.println(dailyLimit);
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);
        accountRepository.updateAccount(destinationAccount);
        log.info("Transfer completed");
    }
}
