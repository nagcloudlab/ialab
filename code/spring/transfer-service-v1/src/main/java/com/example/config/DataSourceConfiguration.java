package com.example.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfiguration {

    @Value("${DB_DRIVER_CLASS_NAME}")
    private String driverClassName;
    @Value("${DB_URL}")
    private String url;
    @Value("${DB_USERNAME}")
    private String username;
    @Value("${DB_PASSWORD}")
    private String password;

    @Value("#{systemProperties['os.name']}")
    private String os;

    @Bean
    @Description("Data-source for the underlying RDB we are using")
    public DataSource dataSource(Environment env) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
