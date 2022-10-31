package com.example.repository;

import com.example.entity.Account;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

//@Component
@Repository
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcAccountRepository.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        log.info("JdbcAccountRepository component created");
    }

    public Account loadAccount(String number) {
        log.info("Loading account " + number);
        return jdbcTemplate.queryForObject("select * from accounts where number=?", (rs, rowIdx) -> {
            Account account = new Account();
            account.setNumber(number);
            account.setBalance(rs.getDouble("balance"));
            return account;
        }, number);
    }

    public void updateAccount(Account account) {
        log.info("Updating account " + account.getNumber());
        jdbcTemplate.update("update accounts set balance=? where number=?", account.getBalance(), account.getNumber());
    }

}
