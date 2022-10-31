package com.example.config;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import({
        DataSourceConfiguration.class
})
@ComponentScan(
        basePackages = {
                "com.example.repository",
                "com.example.service",
                "com.example.config",
                "com.example.aspects"
        })
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource("classpath:transfer.properties")
public class ApplicationConfiguration {

//
//    @Bean
//    @Description("Provides access to data from the Accounts table")
//    public AccountRepository jdbcAccountRepository(DataSource dataSource) {
//        return new JdbcAccountRepository(dataSource);
//    }

//    @Bean("transferService")
//    @Scope("singleton")
//    @Description("Handles all transfer related use-cases")
//    public TransferService transferService(AccountRepository jdbcAccountRepository) {
//        return new UPITransferService(jdbcAccountRepository);
//    }

}
