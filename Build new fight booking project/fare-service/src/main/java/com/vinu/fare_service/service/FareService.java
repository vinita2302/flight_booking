package com.vinu.fare_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinu.fare_service.entity.Fare;
import com.vinu.fare_service.repository.FareRepository;

@Service
public class FareService {

    @Autowired
    private FareRepository fareRepository;

    public Fare getFare(String flightNumber) {
        return fareRepository.findByFlightNumber(flightNumber);
    }
}
