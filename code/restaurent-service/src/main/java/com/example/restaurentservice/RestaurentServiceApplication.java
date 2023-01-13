package com.example.restaurentservice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestaurentServiceApplication {

	@GetMapping("/restaurents/{restId}/items")
	public ResponseEntity<?> getItemsByRestaurent() {
		/// ..
		List<String> items = List.of("item1", "item2");
		return ResponseEntity.ok(items);
	}

	public static void main(String[] args) {
		SpringApplication.run(RestaurentServiceApplication.class, args);
	}

}
