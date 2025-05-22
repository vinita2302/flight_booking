package com.vinu.booking_service.service;

import com.vinu.booking_service.client.PaymentServiceClient;
import com.vinu.booking_service.client.SearchServiceClient;
import com.vinu.booking_service.dto.*;
import com.vinu.booking_service.dto.BookingRequest;
import com.vinu.booking_service.dto.BookingResponse;
import com.vinu.booking_service.dto.PaymentRequest;
import com.vinu.booking_service.entity.Booking;
import com.vinu.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SearchServiceClient searchServiceClient;

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    public BookingResponse createBooking(BookingRequest request) {
        // 1. Save booking with PENDING_PAYMENT
        Booking booking = new Booking();
        booking.setFlightId(request.getFlightId());
        booking.setPassengerName(request.getPassengerName());
        booking.setEmail(request.getEmail());
        booking.setContact(request.getContact());
        booking.setFare(request.getFare());
        booking.setStatus("PENDING_PAYMENT");

        Booking saved = bookingRepository.save(booking);

        // 2. Call Payment Service
        PaymentRequest paymentRequest = new PaymentRequest(
                saved.getBookingId(),
                saved.getFare(),
                "CARD" // default
        );

        paymentServiceClient.processPayment(paymentRequest);

        return new BookingResponse(saved.getBookingId(), saved.getStatus());
    }

    public BookingResponse confirmBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("CONFIRMED");
        bookingRepository.save(booking);

        // Reduce seat via Search Service
        searchServiceClient.reduceSeats(booking.getFlightId());

        return new BookingResponse(booking.getBookingId(), booking.getStatus());
    }

    public BookingResponse getBookingById(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return new BookingResponse(
                booking.getBookingId(),
                booking.getStatus()
        );
    }

}
