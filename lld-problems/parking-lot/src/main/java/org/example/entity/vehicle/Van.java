package org.example.entity.vehicle;

import org.example.entity.ParkingTicket;

public class Van extends Vehicle {
    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
