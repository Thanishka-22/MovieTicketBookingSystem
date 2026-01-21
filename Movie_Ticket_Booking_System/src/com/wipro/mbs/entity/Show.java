package com.wipro.mbs.entity;

public class Show {
    private String showId;
    private String movieId;
    private int availableSeats;
    private double ticketPrice;

    public Show(String showId, String movieId,
                int availableSeats, double ticketPrice) {
        this.showId = showId;
        this.movieId = movieId;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public String getShowId() {
        return showId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
