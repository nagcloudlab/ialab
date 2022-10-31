package com.example;

import com.example.config.ApplicationConfiguration;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(UPITransferService.class);

    public static void main(String[] args) {

        log.info("-------------------------------------------------------");

        ConfigurableApplicationContext applicationContext =
                // new ClassPathXmlApplicationContext("transfer-service.xml");
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        log.info("-------------------------------------------------------");

        TransferService transferService1=applicationContext.getBean("transferService",TransferService.class);
        transferService1.transfer(100.00,"1","2");

        log.info("-------------------------------------------------------");
        applicationContext.close();


    }

}


// summary , spring manages application components based dependency inversion principle