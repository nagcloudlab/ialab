package com.example.repository;

import com.example.model.Account;

/**
 *
 *  Author : repo-ream
 *
 */

public class JpaAccountRepository implements AccountRepository{

    public JpaAccountRepository() {
        System.out.println("JpaAccountRepository instance created.");
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
