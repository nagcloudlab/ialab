package com.example;

import com.example.service.TransactionHistoryService;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import com.foo.FooConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {

        log.info("-------------------------------------------------------");
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        log.info("-------------------------------------------------------");

    }

}
