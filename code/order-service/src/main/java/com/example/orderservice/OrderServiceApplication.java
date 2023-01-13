package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class OrderServiceApplication {

	// @Bean
	// RestTemplate restTemplate() {
	// return new RestTemplate();
	// }

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping(value = "/")
	public ResponseEntity<?> index() {
		System.out.println("/");
		ResponseEntity<String[]> responseEntity = restTemplate
				.getForEntity("http://localhost:8082/restaurents/123/items", String[].class);
		String[] items = responseEntity.getBody();
		return ResponseEntity.ok().body(items);
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
