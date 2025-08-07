package org.example.entity;

public class Entrance {
    public int id;

    public ParkingTicket getTicket() {
        // generate and return ticket
        return new ParkingTicket();
    }
}
