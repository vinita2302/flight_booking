package com.vinu.booking_service.controller;

import com.vinu.booking_service.dto.BookingRequest;
import com.vinu.booking_service.dto.BookingResponse;
import com.vinu.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingResponse bookTicket(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    @PutMapping("/confirm/{bookingId}")
    public BookingResponse confirmTicket(@PathVariable Long bookingId) {
        return bookingService.confirmBooking(bookingId);
    }

    @GetMapping("/{bookingId}")
    public BookingResponse getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

}
