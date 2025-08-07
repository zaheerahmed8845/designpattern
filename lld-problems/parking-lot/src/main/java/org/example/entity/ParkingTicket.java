package org.example.entity;

import org.example.entity.payment.Payment;
import org.example.entity.vehicle.Vehicle;
import org.example.enums.TicketStatus;

public class ParkingTicket {
    public int ticketNo;
    public java.time.LocalDateTime entryTime;
    public java.time.LocalDateTime exitTime;
    public double amount;
    public TicketStatus status;
    public Vehicle vehicle;
    Payment payment;
    Entrance entrance;
    Exit exitIns;
}
