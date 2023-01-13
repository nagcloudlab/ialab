package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GreetingServiceApplication {

	@GetMapping("/greeting/{language}")
	public String greeting(@PathVariable String language) {
		if (language.equals("en"))
			return "Hello";
		if (language.equals("tn")) {
			return "Vanakkam";
		}
		return "oops, dono how to greet you!!!";
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

}
