package com.vinu.check_in.service;

import com.vinu.check_in.client.BookingServiceClient;
import com.vinu.check_in.dto.BookingResponse;
import com.vinu.check_in.dto.CheckinRequest;
import com.vinu.check_in.dto.CheckinResponse;
import com.vinu.check_in.entity.Checkin;
import com.vinu.check_in.repository.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckinService {

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired
    private BookingServiceClient bookingServiceClient;

    public CheckinResponse checkin(CheckinRequest request) {
        BookingResponse booking;
        try {
            booking = bookingServiceClient.getBookingById(request.getBookingId());
        } catch (Exception e) {
            throw new RuntimeException("Invalid Booking ID. Check-in not allowed.");
        }

        if (!"CONFIRMED".equalsIgnoreCase(booking.getStatus())) {
            throw new RuntimeException("Booking is not CONFIRMED. Check-in not allowed.");
        }

        Checkin existingSeat = checkinRepository.findBySeatNumber(request.getSeatNumber());
        if (existingSeat != null) {
            throw new RuntimeException("Seat " + request.getSeatNumber() + " is already assigned.");
        }

        Checkin checkin = new Checkin();
        checkin.setBookingId(request.getBookingId());
        checkin.setSeatNumber(request.getSeatNumber());
        checkin.setStatus("CHECKED_IN");

        Checkin saved = checkinRepository.save(checkin);

        return new CheckinResponse(
                saved.getCheckinId(),
                saved.getBookingId(),
                saved.getSeatNumber(),
                saved.getStatus()
        );
    }

    public CheckinResponse getCheckinByBookingId(Long bookingId) {
        Checkin checkin = checkinRepository.findByBookingId(bookingId);
        if (checkin == null) return null;

        return new CheckinResponse(
                checkin.getCheckinId(),
                checkin.getBookingId(),
                checkin.getSeatNumber(),
                checkin.getStatus()
        );
    }
}
