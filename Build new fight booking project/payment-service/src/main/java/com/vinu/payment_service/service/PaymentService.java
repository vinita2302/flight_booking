package com.vinu.payment_service.service;

import com.vinu.payment_service.dto.PaymentRequest;
import com.vinu.payment_service.entity.Payment;
import com.vinu.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public String processPayment(PaymentRequest request) {
        // Dummy logic to simulate payment success
        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setPaymentStatus("SUCCESS");

        paymentRepository.save(payment);
        return "Payment Successful for Booking ID: " + request.getBookingId();
    }
}
