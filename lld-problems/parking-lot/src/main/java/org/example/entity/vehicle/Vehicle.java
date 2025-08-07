package org.example.entity.vehicle;

import org.example.entity.ParkingTicket;

public abstract class Vehicle {
    public String licenseNo;
    public ParkingTicket ticket;

    public abstract void assignTicket(ParkingTicket ticket);
}
