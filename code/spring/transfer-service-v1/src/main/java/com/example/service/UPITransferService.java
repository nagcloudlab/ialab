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
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("transferService")
@Service("transferService")
public class UPITransferService implements TransferService {

    private static final Logger log = LoggerFactory.getLogger(UPITransferService.class);
    private AccountRepository accountRepository;

    @Value("${daily.limit:10}")
    private int dailyLimit;

    @Autowired
    public UPITransferService(@Qualifier("jdbcAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        log.info("UPITransferService component created");
    }

    @PostConstruct
    public void init(){
        log.info("init()");
    }

    @PreDestroy
    public void destroy(){
        log.info("destroy()");
    }

    public void transfer(double amount, String source, String destination) {
        log.info("Transfer initiated");
        System.out.println(dailyLimit);
        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);
        //...
        if(1!=1)
            throw new IllegalStateException("oops");
        accountRepository.updateAccount(destinationAccount);
        log.info("Transfer completed");
    }
}
