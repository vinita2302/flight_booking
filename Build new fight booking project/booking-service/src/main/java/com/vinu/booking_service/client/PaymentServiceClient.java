package com.vinu.booking_service.client;

import com.vinu.booking_service.dto.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentServiceClient {

    @PostMapping("/api/payments/process")
    String processPayment(PaymentRequest request);
}
