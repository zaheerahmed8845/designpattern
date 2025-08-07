package org.example;

import org.example.entity.*;
import org.example.entity.parkingfee.HourlyRateStrategy;
import org.example.entity.parkingspot.Compact;
import org.example.entity.parkingspot.ParkingSpot;
import org.example.entity.payment.Cash;
import org.example.entity.payment.Payment;
import org.example.entity.vehicle.Car;
import org.example.entity.vehicle.Vehicle;
import org.example.enums.TicketStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = ParkingLot.getInstance();

        Entrance entrance = new Entrance();
        entrance.id = 1;
        lot.entrances.put("Main", entrance);

        Exit exit = new Exit();
        exit.id = 1;
        lot.exits.put("Main", exit);

        DisplayBoard board = new DisplayBoard();
        board.id = 101;

        ParkingSpot compactSpot = new Compact(1001);
        board.addParkingSpot("Compact", Arrays.asList(compactSpot));
        lot.spots.put("C1001", compactSpot);
        lot.displayBoards.add(board);

        lot.parkingRate = new ParkingRate(new HourlyRateStrategy(50));

        Vehicle car = new Car("KA01AB1234");
        ParkingTicket ticket = lot.getParkingTicket(car);

        if (ticket != null) {
            System.out.println("Ticket issued for vehicle " + car.licenseNo);
            compactSpot.assignVehicle(car);
        }

        Thread.sleep(2000); // Simulate parked time

        exit.validateTicket(ticket);
        double hours = Duration.between(ticket.exitTime, ticket.entryTime).toHours();
        ticket.amount = lot.parkingRate.calculate(hours);

        System.out.println("Amount to pay: Rs. " + ticket.amount);

        Payment payment = new Cash();
        payment.amount = ticket.amount;
        payment.timestamp = LocalDateTime.now();
        if (payment.initiateTransaction()) {
            ticket.status = TicketStatus.PAID;
            compactSpot.removeVehicle();
            System.out.println("Payment completed. You may exit now.");
        }
    }
}