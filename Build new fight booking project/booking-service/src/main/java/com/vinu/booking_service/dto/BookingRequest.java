package com.vinu.booking_service.dto;


public class BookingRequest {
    private Long flightId;
    private String passengerName;
    private String email;
    private String contact;
    private double fare;

    public  BookingRequest(){

    }
    public BookingRequest(Long flightId, String passengerName, String email, String contact, double fare) {
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.email = email;
        this.contact = contact;
        this.fare = fare;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
