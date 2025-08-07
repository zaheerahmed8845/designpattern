package org.example.entity;

import org.example.enums.TicketStatus;

import java.time.LocalDateTime;

public class Exit {
    public int id;

    public void validateTicket(ParkingTicket ticket) {
        ticket.exitTime = LocalDateTime.now();
        ticket.status = TicketStatus.VALIDATED;
    }
}
