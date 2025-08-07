package org.example;

import org.example.entity.*;
import org.example.entity.parkingspot.Compact;
import org.example.entity.parkingspot.ParkingSpot;
import org.example.entity.vehicle.Car;
import org.example.entity.vehicle.Vehicle;
import org.example.enums.TicketStatus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize singleton ParkingLot instance
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Setup address
        Address address = new Address();
        address.address = "123 Main St";
        address.city = "Metropolis";
        address.state = "Metro State";
        address.country = "Countryland";
        address.zipCode = 12345;

        // Setup parking lot info
        parkingLot.id = 1;
        parkingLot.name = "Downtown Parking";
        parkingLot.address = address;

        // Add an entrance and exit
        Entrance entrance = new Entrance();
        entrance.id = 101;
        parkingLot.entrances.put("ENTRANCE_1", entrance);

        Exit exit = new Exit();
        exit.id = 201;
        parkingLot.exits.put("EXIT_1", exit);

        // Add parking spots
        ParkingSpot compactSpot = new Compact();
        compactSpot.id = 1;
        compactSpot.isFree = true;
        parkingLot.spots.put("SPOT_1", compactSpot);

        // Add display board
        DisplayBoard board = new DisplayBoard();
        board.id = 1;
        board.addParkingSpot("COMPACT", List.of(compactSpot));
        parkingLot.displayBoards.add(board);

        // Simulate a customer arriving
        Vehicle vehicle = new Car();
        vehicle.licenseNo = "KA-01-1234";

        // Assign ticket
        ParkingTicket ticket = entrance.getTicket();
        ticket.ticketNo = 1;
        ticket.entryTime = java.time.LocalDateTime.now();
        ticket.vehicle = vehicle;
        ticket.status = TicketStatus.IN_USE;
        vehicle.assignTicket(ticket);

        // Assign vehicle to spot
        if (compactSpot.assignVehicle(vehicle)) {
            System.out.println("Vehicle parked at spot ID: " + compactSpot.id);
        }

        // Update system ticket map
        parkingLot.tickets.put("TICKET_1", ticket);

        // Simulate exit
        ticket.exitTime = java.time.LocalDateTime.now().plusHours(2);
        ticket.amount = 40.0;
        ticket.status = TicketStatus.PAID;

        compactSpot.removeVehicle();
        exit.validateTicket();

        System.out.println("Vehicle exited and ticket validated. Total fee: ₹" + ticket.amount);
    }
}