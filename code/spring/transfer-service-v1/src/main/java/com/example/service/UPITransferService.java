package com.example.service;

import com.example.dto.TransferStatus;
import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TransactionType;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Slf4j
@Service("transferService")
public class UPITransferService implements TransferService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    @Value("${daily.limit:10}")
    private int dailyLimit;

    @Autowired
    public UPITransferService(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        log.info("UPITransferService component created");
    }

    @PostConstruct
    public void init() {
        log.info("init()");
    }

    @PreDestroy
    public void destroy() {
        log.info("destroy()");
    }

    @Transactional(
            transactionManager = "transactionManager",
            rollbackFor = {IllegalStateException.class},
            noRollbackFor = {RuntimeException.class},
            timeout = 30,
            isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public TransferStatus transfer(double amount, String source, String destination) {
        log.info("Transfer initiated");
        System.out.println(dailyLimit);
        Account sourceAccount = accountRepository.findById(source)
                .orElseThrow(() -> new AccountNotFoundException("Source account not found"));
        if (sourceAccount.getBalance() < amount)
            throw new AccountBalanceException("Insufficient balance");
        Account destinationAccount = accountRepository.findById(destination)
                .orElseThrow(() -> new AccountNotFoundException("Destination account not found"));
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        accountRepository.save(sourceAccount);
        if (1 != 1)
            throw new IllegalStateException("oops");
        accountRepository.save(destinationAccount);

        Transaction debitTransaction = new Transaction();
        debitTransaction.setType(TransactionType.DEBIT);
        debitTransaction.setAmount(amount);
        debitTransaction.setDate(new Date());
        debitTransaction.setAccount(sourceAccount);

        Transaction creditTransaction = new Transaction();
        creditTransaction.setType(TransactionType.CREDIT);
        creditTransaction.setAmount(amount);
        creditTransaction.setDate(new Date());
        creditTransaction.setAccount(destinationAccount);

        Transaction debitTxn = transactionRepository.save(debitTransaction);
        transactionRepository.save(creditTransaction);

        TransferStatus transferStatus = new TransferStatus();
        transferStatus.setStatus("success");
        transferStatus.setTxnId(String.valueOf(debitTxn.getId()));

        log.info("Transfer completed");
        return transferStatus;
    }
}
