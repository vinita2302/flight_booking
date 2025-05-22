package com.vinu.check_in.client;

import com.vinu.check_in.dto.BookingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service")

public interface BookingServiceClient {

    @GetMapping("/api/bookings/{bookingId}")
    BookingResponse getBookingById(@PathVariable Long bookingId);

}
