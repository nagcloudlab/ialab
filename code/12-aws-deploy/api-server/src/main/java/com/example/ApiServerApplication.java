package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = { "*" })
public class ApiServerApplication {

	@GetMapping("/api/subjects")
	public ResponseEntity<?> getSubject() {
		List<String> subjects = List.of("java", "javascript", "spring", "react", "aws");
		return ResponseEntity.ok(subjects);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiServerApplication.class, args);
	}

}
