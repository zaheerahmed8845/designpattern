package org.example.entity;


import org.example.enums.SeatClass;
import org.example.enums.SeatStatus;
import org.example.enums.SeatType;

public class FlightSeat extends Seat {
    public double fare;
    public SeatStatus status = SeatStatus.AVAILABLE;
    public String reservationNumber; // filled when booked

    public FlightSeat(String seatNumber, SeatType type, SeatClass seatClass, double fare) {
        super(seatNumber, type, seatClass);
        this.fare = fare;
    }
}
