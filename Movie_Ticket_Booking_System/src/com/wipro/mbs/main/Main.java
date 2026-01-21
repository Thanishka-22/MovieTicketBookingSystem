package com.wipro.mbs.main;

import java.util.ArrayList;
import com.wipro.mbs.entity.*;
import com.wipro.mbs.service.*;
import com.wipro.mbs.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("U001", "Rohit", "9876543210"));

        ArrayList<Show> shows = new ArrayList<>();
        shows.add(new Show("S101", "M001", 50, 200));

        ArrayList<Booking> bookings = new ArrayList<>();

        BookingService service =
                new BookingService(users, shows, bookings);

        try {
            Booking b = service.bookTicket("U001", "S101", 2);

            System.out.println("Booking ID: " + b.getBookingId());
            System.out.println("Total Fare: " + b.getTotalFare());

            service.printUserBookings("U001");

            service.cancelBooking(b.getBookingId());
            System.out.println("Booking Cancelled");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
