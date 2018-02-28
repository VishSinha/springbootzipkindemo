package com.springboot.zipkin.demo.springbootzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@CrossOrigin
public class UserGreetingService {
	
	@RequestMapping("/api/user/greet")
	public String greet() {
		
		String greetingMsg = "Hello";
		
		String userName = restTemplate().getForObject("http://localhost:3001/api/user/name", String.class);
		String userAddress = restTemplate().getForObject("http://localhost:3002/api/user/address", String.class);
		
		return greetingMsg + " " + userName + "!\n\n" + userAddress;
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UserGreetingService.class,
				"--spring.application.name=user-greeting-service",
				"--server.port=3000"
		);
	}
}
