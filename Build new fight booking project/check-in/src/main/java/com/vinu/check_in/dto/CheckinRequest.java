package com.vinu.check_in.dto;

public class CheckinRequest {
    private Long bookingId;
    private String seatNumber;

    public CheckinRequest() {}

    public CheckinRequest(Long bookingId, String seatNumber) {
        this.bookingId = bookingId;
        this.seatNumber = seatNumber;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
