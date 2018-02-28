package com.springboot.zipkin.demo.springbootzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserAddressService {
	
	@RequestMapping("/api/user/address")
	public String getUserAddress() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "123 Main St \nNew York, NY - 10001";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserAddressService.class,
				"--spring.application.name=user-address-service",
				"--server.port=3002"
		);
	}
}
