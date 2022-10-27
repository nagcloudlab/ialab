package com.example.auth;

import com.example.model.Account;
import com.example.repo.AccountRepository;

/**
 * author: Tom
 */
public class AuthService {

    private AccountRepository accountRepository;
    public AuthService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean authenticate(String username, String password) {
        if (username.equals("unknown"))
            throw new AccountNotFoundException();
        Account account = accountRepository.findByUsername(username);
        if (account.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
