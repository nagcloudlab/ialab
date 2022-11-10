package com.example.repo;

import com.example.model.Account;

/**
 * author: jerry
 */
public class JdbcAccountRepository implements AccountRepository {

    @Override
    public Account findByUsername(String username){
        // get account details from database
        // TODO
        return new Account(username,"secret");
    }

}
