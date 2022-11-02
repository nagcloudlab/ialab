package com.example.repository;

import com.example.entity.Account;
import com.example.service.UPITransferService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

//@Component
@Slf4j
@Repository
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaAccountRepository() {
        log.info("JpaAccountRepository component created");
    }
    public Account loadAccount(String number) {
        log.info("Loading account " + number);
        return entityManager.find(Account.class,number);
    }

    public void updateAccount(Account account) {
        log.info("Updating account " + account.getNumber());
        entityManager.merge(account);
    }

}
