package org.example.entity.vehicle;

import org.example.entity.ParkingTicket;

public abstract class Vehicle {
    public String licenseNo;
    ParkingTicket ticket;

    public Vehicle(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
