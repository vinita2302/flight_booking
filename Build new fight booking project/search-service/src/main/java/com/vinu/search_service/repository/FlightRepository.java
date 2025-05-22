package com.vinu.search_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinu.search_service.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findBySourceAndDestinationAndDate(String source, String destination, LocalDate date);

    Flight findByFlightNumber(String flightNumber);  // ➕ Added method for seat update logic
}
