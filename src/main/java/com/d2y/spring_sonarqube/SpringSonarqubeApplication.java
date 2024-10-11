package com.d2y.spring_sonarqube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSonarqubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSonarqubeApplication.class, args);
	}

	@RestController
	public class HelloWorldController {
		@GetMapping("/hello")
		public String hello() {
			return "Hello, World!";
		}
	}
}
