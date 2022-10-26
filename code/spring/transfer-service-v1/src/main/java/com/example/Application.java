package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(UPITransferService.class);

    public static void main(String[] args) {

        log.info("-------------------------------------------------------");

        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("transfer-service.xml");

        log.info("-------------------------------------------------------");

        TransferService transferService=applicationContext.getBean("transferService",TransferService.class);
        transferService.transfer(50.00, "1", "2");

        log.info("-------------------------------------------------------");


    }

}


// summary , spring manages application components based dependency inversion principle