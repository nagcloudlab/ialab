package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

public class Application {

    public static void main(String[] args) {

        // phase-1 : init / booting
        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
//        AccountRepository jpaAccountRepository = new JpaAccountRepository();
        TransferService transferService = new UPITransferService(jdbcAccountRepository);

        System.out.println("-".repeat(100));

        //phase-2 : use
        transferService.transfer(100.00, "1", "2");
        System.out.println("-".repeat(50));

        System.out.println("-".repeat(100));
        //phase-3 : Destroy
        // proper clean-up


    }

}
