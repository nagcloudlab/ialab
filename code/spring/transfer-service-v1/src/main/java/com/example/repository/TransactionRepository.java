package com.example.repository;

import com.example.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

    @Query("from Transaction t where t.account.number=:number")
    List<Transaction> findByAccount(String number);

}
