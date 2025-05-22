package com.vinu.fare_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vinu.fare_service.entity.Fare;
import com.vinu.fare_service.service.FareService;

@RestController
@RequestMapping("/api/fare")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping("/{flightNumber}")
    public Fare getFare(@PathVariable String flightNumber) {
        return fareService.getFare(flightNumber);
    }
}
