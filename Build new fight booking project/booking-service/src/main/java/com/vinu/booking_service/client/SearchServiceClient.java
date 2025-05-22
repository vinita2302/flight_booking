package com.vinu.booking_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "search-service")
public interface SearchServiceClient {

    @PutMapping("/api/flights/reduceSeats/{flightId}")
    void reduceSeats(@PathVariable("flightId") Long flightId);
}
