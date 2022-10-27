package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

/**
 *
 *  Author : repo-ream
 *
 */

public class JdbcAccountRepository implements AccountRepository{

    private static final Logger LOGGER=Logger.getLogger("ts"); // singleton

    public JdbcAccountRepository() {
        LOGGER.debug("JdbcAccountRepository instance created.");
    }

    public Account loadAccount(String number) {
        // TODO
        LOGGER.info("Loading account " + number);
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        // TODO
        LOGGER.info("updating account " + account.getNumber());
    }


}
