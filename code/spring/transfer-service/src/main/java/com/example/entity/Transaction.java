package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="transaction_history")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="txn_id")
    private int id;
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ManyToOne
    @JoinColumn(name="acc_number")
    private Account account;



}
