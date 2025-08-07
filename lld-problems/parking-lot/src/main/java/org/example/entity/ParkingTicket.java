package org.example.entity;

import org.example.entity.payment.Payment;
import org.example.entity.vehicle.Vehicle;
import org.example.enums.TicketStatus;

import java.time.LocalDateTime;

public class ParkingTicket {
    public int ticketNo;
    public LocalDateTime entryTime;
    public LocalDateTime exitTime;
    public double amount;
    public TicketStatus status;
    public Vehicle vehicle;
    Payment payment;
    Entrance entrance;
    Exit exitIns;
}
