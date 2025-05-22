package com.vinu.fare_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinu.fare_service.entity.Fare;

public interface FareRepository extends JpaRepository<Fare, String> {
    Fare findByFlightNumber(String flightNumber);
}
