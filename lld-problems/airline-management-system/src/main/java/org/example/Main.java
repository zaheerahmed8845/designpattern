package org.example;

import org.example.command.AssignSeatCommand;
import org.example.command.CommandInvoker;
import org.example.command.MakeReservationCommand;
import org.example.command.ProcessPaymentCommand;
import org.example.component.FlightReservation;
import org.example.component.Itinerary;
import org.example.component.ItineraryBuilder;
import org.example.entity.*;
import org.example.enums.*;
import org.example.observer.FlightInstance;
import org.example.observer.NotificationService;
import org.example.payment.Payment;
import org.example.payment.PaymentFactory;
import org.example.person.Customer;
import org.example.person.Passenger;
import org.example.search.SearchCatalog;
import org.example.strategy.CardPaymentStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Airports
        Airport blr = new Airport("BLR", "Kempegowda Intl");
        Airport bom = new Airport("BOM", "Mumbai Intl");

        // Airline, Aircraft
        Airline ams = new Airline("AM", "Air Model");
        // --- Aircraft seat templates (no fare/status here) ---
        Aircraft a320 = new Aircraft("A320", "Airbus A320", 3);
        a320.seats.add(new Seat("1A", SeatType.REGULAR, SeatClass.ECONOMY));
        a320.seats.add(new Seat("1B", SeatType.REGULAR, SeatClass.ECONOMY));
        a320.seats.add(new Seat("1C", SeatType.REGULAR, SeatClass.ECONOMY));

        // --- Flight & instance ---
        Flight f = new Flight("AM101", blr, bom, 95);
        ams.addFlight(f);
        FlightInstance fi = new FlightInstance(f, LocalDateTime.now().plusDays(1), a320);

        // Create per-instance seats with fare from the templates
        for (Seat tmpl : a320.seats) {
            fi.addSeat(new FlightSeat(tmpl.seatNumber, tmpl.type, tmpl.seatClass, 120.0));
        }
        f.addInstance(fi);

        // Index in singleton search catalog
        SearchCatalog.getInstance().addFlight(fi);

        // Customer & passenger
        Customer customer = new Customer("Zaheer Ahmed", "zaheer@example.com", "+91-90000-00000");
        Passenger pax = new Passenger("Saad Ahmed", "saad@example.com", "+91-80000-00000", "P1234567");

        // Observer wiring: notifications go to customer via EMAIL
        NotificationService notifier = new NotificationService(customer, NotificationType.EMAIL);
        // Reservation and the flight instance both publish events
        // (reservation created below, fi already exists)
        fi.registerObserver(notifier);

        // Build itinerary (Builder + Command)
        ItineraryBuilder builder = new ItineraryBuilder().startingAirport(blr).finalAirport(bom).addPassenger(pax);

        CommandInvoker invoker = new CommandInvoker();

        // 1) Real-time reservation creation
        MakeReservationCommand makeRes = new MakeReservationCommand(builder, fi);
        invoker.run(makeRes);
        FlightReservation reservation = makeRes.getReservation();
        reservation.registerObserver(notifier); // get notified on confirmation

        // 2) Seat assignment
        FlightSeat seat = fi.seats.get(0);
        invoker.run(new AssignSeatCommand(reservation, pax, seat));

        // 3) Payment via Strategy + Factory
        Payment payment = PaymentFactory.create(PaymentMethod.CREDIT_CARD, reservation.getCost(), "Zaheer Ahmed", "4111-1111-1111-1111");
        invoker.run(new ProcessPaymentCommand(payment, new CardPaymentStrategy()));

        // 4) Confirm reservation -> Observer fires Template notifications
        reservation.confirm();

        // 5) Later, a delay occurs -> Observer fires notifications again
        fi.setStatus(FlightStatus.DELAYED);

        // 6) Composite total
        Itinerary itinerary = builder.build();
        System.out.println("Itinerary total cost = $" + itinerary.getCost());

        // 7) Singleton search demo
        System.out.println("Search results: " +
                SearchCatalog.getInstance().searchFlights(null, blr, bom, LocalDate.now().plusDays(1)).size());
    }
}