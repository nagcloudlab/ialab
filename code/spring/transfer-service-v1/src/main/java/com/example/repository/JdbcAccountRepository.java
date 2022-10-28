package com.example.repository;

import com.example.entity.Account;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger log = LoggerFactory.getLogger(UPITransferService.class);
    private DataSource dataSource;

    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        log.info("JdbcAccountRepository component created");
    }

    public Account loadAccount(String number) {
        log.info("Loading account " + number);
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        log.info("Updating account " + account.getNumber());
    }

}
