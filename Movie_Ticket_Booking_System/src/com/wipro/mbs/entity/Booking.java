package com.wipro.mbs.entity;

public class Booking {
    private String bookingId;
    private String userId;
    private String showId;
    private int seatsBooked;
    private double totalFare;

    public Booking(String bookingId, String userId,
                   String showId, int seatsBooked,
                   double totalFare) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showId = showId;
        this.seatsBooked = seatsBooked;
        this.totalFare = totalFare;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public double getTotalFare() {
        return totalFare;
    }
}
