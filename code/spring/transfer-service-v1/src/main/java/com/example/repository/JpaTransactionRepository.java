package com.example.repository;

import com.example.entity.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaTransactionRepository implements TransactionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Transaction transaction) {
        entityManager.persist(transaction);
    }
}
