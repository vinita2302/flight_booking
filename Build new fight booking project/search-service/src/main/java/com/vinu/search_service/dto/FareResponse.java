package com.vinu.search_service.dto;


public class FareResponse {
    private String flightNumber;
    private String flightName;
    private double fare;

    public FareResponse(String flightNumber, String flightName, double fare) {
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.fare = fare;
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

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
