package org.example.entity;

import org.example.person.Guest;

public class RoomBookingEvent {
    public final String reservationNumber;
    public final String message;
    public final Guest guest;

    public RoomBookingEvent(String reservationNumber, String message, Guest guest) {
        this.reservationNumber = reservationNumber;
        this.message = message;
        this.guest = guest;
    }
}
