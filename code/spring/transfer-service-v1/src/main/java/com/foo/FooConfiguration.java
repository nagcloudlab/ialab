package com.foo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class FooConfiguration {

    @Bean
    public String foo() {
        return "foo";
    }

}
