package org.example.entity;

import org.example.entity.vehicle.Vehicle;
import org.example.enums.TicketStatus;

import java.time.LocalDateTime;
import java.util.Random;

public class Entrance {
    public int id;

    public ParkingTicket getTicket(Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket();
        ticket.ticketNo = new Random().nextInt(10000);
        ticket.entryTime = LocalDateTime.now();
        ticket.status = TicketStatus.ISSUED;
        ticket.vehicle = vehicle;
        vehicle.assignTicket(ticket);
        return ticket;
    }
}
