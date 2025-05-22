package com.vinu.search_service.client;

import com.vinu.search_service.dto.FareResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fare-service")
public interface FareClient {
    @GetMapping("/api/fare/{flightNumber}")
    FareResponse getFare(@PathVariable String flightNumber);
}
