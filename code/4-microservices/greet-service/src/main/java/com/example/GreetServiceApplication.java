package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
public class GreetServiceApplication {

    @GetMapping("/hello")
    public Mono<String> hello() {
        System.out.println(Thread.currentThread());
       return Mono
               .fromCallable(()->"Hello, World!")
               .delayElement(Duration.ofSeconds(2));
    }

    public static void main(String[] args) {
        SpringApplication.run(GreetServiceApplication.class, args);
    }

}
