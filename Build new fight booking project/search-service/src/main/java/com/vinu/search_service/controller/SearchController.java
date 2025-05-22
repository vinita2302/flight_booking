package com.vinu.search_service.controller;

import com.vinu.search_service.dto.SearchResponse;
import com.vinu.search_service.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class SearchController {

    @Autowired
    private SearchService searchService;

    // Search available flights
    @GetMapping("/search")
    public List<SearchResponse> searchFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return searchService.search(source, destination, date);
    }

    //  Reduce seat after booking
    @PutMapping("/reduceSeats/{flightId}")
    public String reduceSeats(@PathVariable Long flightId) {
        boolean success = searchService.reduceSeatAvailabilityById(flightId);
        return success ? " Seat reduced successfully." : " No seats available or flight not found.";
    }
}
