package com.vinu.search_service.entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity

@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String flightName;
    private String source;
    private String destination;
    @Column(name = "date")
    private LocalDate date;
    private int availableSeats;



    private LocalTime departureTime;
    private LocalTime arrivalTime;


    public Flight() {
    }

    public Flight(Long id, String flightNumber, String flightName, String source, String destination, LocalDate date, LocalTime arrivalTime, LocalTime departureTime,int availableSeats) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.availableSeats=availableSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
