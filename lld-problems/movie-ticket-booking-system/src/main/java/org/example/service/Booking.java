package org.example.service;

import org.example.enums.BookingStatus;

import java.util.List;

public class Booking {
    public final String id;
    public final String userId;
    public final String showId;
    public final List<String> seatIds;
    public final double amount;
    public BookingStatus status = BookingStatus.PENDING;

    public Booking(String id, String userId, String showId, List<String> seatIds, double amount) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seatIds = List.copyOf(seatIds);
        this.amount = amount;
    }
}
