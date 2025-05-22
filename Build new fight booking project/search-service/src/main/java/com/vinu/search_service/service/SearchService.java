package com.vinu.search_service.service;

import com.vinu.search_service.client.FareClient;
import com.vinu.search_service.dto.SearchResponse;
import com.vinu.search_service.entity.Flight;
import com.vinu.search_service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FareClient fareClient;

    // 🔍 Search flights with fare info
    public List<SearchResponse> search(String source, String destination, LocalDate date) {
        List<Flight> flights = flightRepository.findBySourceAndDestinationAndDate(source, destination, date);

        return flights.stream().map(flight -> {
            double fareAmount = 0.0;
            try {
                var fare = fareClient.getFare(flight.getFlightNumber());
                fareAmount = fare.getFare();
            } catch (Exception e) {
                System.out.println("Error fetching fare for flight: " + flight.getFlightNumber() + " → " + e.getMessage());
            }

            return new SearchResponse(
                    flight.getFlightNumber(),
                    flight.getFlightName(),
                    flight.getSource(),
                    flight.getDestination(),
                    flight.getDate().toString(),
                    flight.getDepartureTime().toString(),
                    flight.getArrivalTime().toString(),
                    fareAmount
            );
        }).collect(Collectors.toList());
    }

    // ✅ Reduce available seats by flight ID
    public boolean reduceSeatAvailabilityById(Long flightId) {
        return flightRepository.findById(flightId).map(flight -> {
            if (flight.getAvailableSeats() > 0) {
                flight.setAvailableSeats(flight.getAvailableSeats() - 1);
                flightRepository.save(flight);
                return true;
            }
            return false;
        }).orElse(false);
    }
}
