package org.example.entity.vehicle;

import org.example.entity.ParkingTicket;

public class Car extends Vehicle {
    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
