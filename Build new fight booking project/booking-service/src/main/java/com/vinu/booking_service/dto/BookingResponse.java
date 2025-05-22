package com.vinu.booking_service.dto;

public class BookingResponse {
    private Long bookingId;
    private String status;


    public  BookingResponse(){

    }
    public BookingResponse(Long bookingId, String status) {
        this.bookingId = bookingId;
        this.status = status;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
