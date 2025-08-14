package org.example.builder;

import org.example.entity.Room;
import org.example.enums.BookingStatus;
import org.example.observer.BookingEventBus;
import org.example.person.Guest;

import java.time.LocalDateTime;

public class RoomBookingBuilder {
    private final RoomBooking booking;

    public RoomBookingBuilder(BookingEventBus bus) {
        this.booking = new RoomBooking(bus);
        booking.createdOn = LocalDateTime.now();
        booking.status = BookingStatus.Requested;
    }

    public RoomBookingBuilder reservationNumber(String id) {
        booking.reservationNumber = id;
        return this;
    }

    public RoomBookingBuilder start(LocalDateTime start) {
        booking.startDate = start;
        return this;
    }

    public RoomBookingBuilder durationDays(int d) {
        booking.durationDays = d;
        return this;
    }

    public RoomBookingBuilder guest(Guest g) {
        booking.guest = g;
        return this;
    }

    public RoomBookingBuilder room(Room r) {
        booking.room = r;
        return this;
    }

    public RoomBookingBuilder advance(double a) {
        booking.advancePayment = a;
        return this;
    }

    public RoomBooking build() {
        return booking;
    }
}
