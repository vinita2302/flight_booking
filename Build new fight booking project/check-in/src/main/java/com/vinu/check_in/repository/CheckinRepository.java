package com.vinu.check_in.repository;

import com.vinu.check_in.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {
    Checkin findByBookingId(Long bookingId);
    Checkin findBySeatNumber(String seatNumber);
}
