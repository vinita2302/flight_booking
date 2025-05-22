package com.vinu.booking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.vinu.booking_service.client")
public class BookingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}
}
