package com.example.repo;

import com.example.model.Account;

public interface AccountRepository {
    Account findByUsername(String username);
}
