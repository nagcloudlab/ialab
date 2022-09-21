package com.example.repository;

import com.example.model.Account;

/**
 *
 *  Author : repo-ream
 *
 */

public class JdbcAccountRepository {

    public JdbcAccountRepository() {
        System.out.println("JdbcAccountRepository instance created.");
    }

    public Account loadAccount(String number) {
        // TODO
        System.out.println("Loading account " + number);
        return new Account(number, 1000.00);
    }

    public void updateAccount(Account account) {
        // TODO
        System.out.println("updating account " + account.getNumber());
    }


}
