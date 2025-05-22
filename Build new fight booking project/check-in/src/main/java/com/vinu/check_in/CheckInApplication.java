package com.vinu.check_in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Enables Feign Clients for communication
public class CheckInApplication {
	public static void main(String[] args) {
		SpringApplication.run(CheckInApplication.class, args);
	}
}
