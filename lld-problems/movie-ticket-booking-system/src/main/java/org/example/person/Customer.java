package org.example.person;

import org.example.entity.Booking;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private final List<Booking> bookings = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean createBooking(Booking b) {
        return bookings.add(b);
    }
}
