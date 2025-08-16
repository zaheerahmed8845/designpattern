package org.example.entity;

import org.example.enums.SeatClass;
import org.example.enums.SeatType;

public class Seat {
    public String seatNumber;
    public SeatType type;
    public SeatClass seatClass;

    public Seat(String seatNumber, SeatType type, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.seatClass = seatClass;
    }
}
