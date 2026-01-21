package com.wipro.mbs.service;

import java.util.ArrayList;
import com.wipro.mbs.entity.*;
import com.wipro.mbs.util.*;

public class BookingService {

    private ArrayList<User> users;
    private ArrayList<Show> shows;
    private ArrayList<Booking> bookings;
    private int bookingCount = 1;

    public BookingService(ArrayList<User> users,
                          ArrayList<Show> shows,
                          ArrayList<Booking> bookings) {
        this.users = users;
        this.shows = shows;
        this.bookings = bookings;
    }

    public boolean validateUser(String userId)
            throws InvalidUserException {

        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return true;
            }
        }
        throw new InvalidUserException();
    }

    public Show findShow(String showId)
            throws ShowNotFoundException {

        for (Show s : shows) {
            if (s.getShowId().equals(showId)) {
                return s;
            }
        }
        throw new ShowNotFoundException();
    }

    public double calculateFare(Show show, int seats) {
        return show.getTicketPrice() * seats;
    }

    public Booking bookTicket(String userId,
                              String showId,
                              int seats) throws Exception {

        validateUser(userId);
        Show show = findShow(showId);

        if (show.getAvailableSeats() < seats) {
            throw new ShowFullException();
        }

        double fare = calculateFare(show, seats);
        show.setAvailableSeats(show.getAvailableSeats() - seats);

        Booking booking = new Booking(
                "B" + bookingCount,
                userId,
                showId,
                seats,
                fare
        );
        bookingCount++;

        bookings.add(booking);
        return booking;
    }

    public void cancelBooking(String bookingId)
            throws BookingNotFoundException {

        Booking found = null;

        for (Booking b : bookings) {
            if (b.getBookingId().equals(bookingId)) {
                found = b;
            }
        }

        if (found == null) {
            throw new BookingNotFoundException();
        }

        for (Show s : shows) {
            if (s.getShowId().equals(found.getShowId())) {
                s.setAvailableSeats(
                    s.getAvailableSeats() + found.getSeatsBooked()
                );
            }
        }

        bookings.remove(found);
    }

    public void printUserBookings(String userId) {
        for (Booking b : bookings) {
            if (b.getUserId().equals(userId)) {
                System.out.println(
                    b.getBookingId() + " "
                  + b.getShowId() + " "
                  + b.getSeatsBooked() + " "
                  + b.getTotalFare()
                );
            }
        }
    }
}
