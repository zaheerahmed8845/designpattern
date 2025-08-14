package org.example;

import org.example.builder.RoomBooking;
import org.example.builder.RoomBookingBuilder;
import org.example.composite.RoomGroup;
import org.example.composite.RoomLeaf;
import org.example.entity.Hotel;
import org.example.entity.HotelBranch;
import org.example.entity.Room;
import org.example.enums.NotificationType;
import org.example.enums.RoomStyle;
import org.example.observer.BookingEventBus;
import org.example.observer.FactoryBackedNotifierObserver;
import org.example.payment.PaymentGateway;
import org.example.payment.PaymentGatewayProxy;
import org.example.payment.RealPaymentGateway;
import org.example.person.Guest;
import org.example.search.Catalog;
import org.example.strategy.CreditCardPayment;
import org.example.strategy.PaymentStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Singleton Catalog + Composite tree of rooms ---
        Catalog catalog = Catalog.getInstance();
        Room r1 = new Room();
        r1.roomNumber = "101";
        r1.style = RoomStyle.Deluxe;
        r1.bookingPrice = 200.0;
        Room r2 = new Room();
        r2.roomNumber = "102";
        r2.style = RoomStyle.Deluxe;
        r2.bookingPrice = 210.0;
        Room r3 = new Room();
        r3.roomNumber = "201";
        r3.style = RoomStyle.Standard;
        r3.bookingPrice = 120.0;

        RoomGroup deluxeGroup = new RoomGroup();
        deluxeGroup.add(new RoomLeaf(r1));
        deluxeGroup.add(new RoomLeaf(r2));

        RoomGroup root = (RoomGroup) catalog.getRoot();
        root.add(deluxeGroup);
        root.add(new RoomLeaf(r3));

        // --- Org ---
        Hotel hotel = new Hotel();
        hotel.name = "GPT Grand";
        HotelBranch branch = new HotelBranch();
        branch.name = "City Center";
        branch.addRoom(r1);
        branch.addRoom(r2);
        branch.addRoom(r3);
        hotel.addLocation(branch);

        // --- Search (via Singleton Catalog) ---
        List<Room> options = catalog.searchRoom(RoomStyle.Deluxe, LocalDate.now().plusDays(1), 2);
        Room chosen = options.isEmpty() ? r1 : options.get(0);

        // --- Observer setup using Factory-backed notifiers ---
        BookingEventBus bus = new BookingEventBus();
        bus.attach(new FactoryBackedNotifierObserver(NotificationType.SMS));
        bus.attach(new FactoryBackedNotifierObserver(NotificationType.EMAIL));

        // --- Build a booking (Builder) & confirm (Observer emits) ---
        Guest guest = new Guest();
        guest.name = "Zaheer"; // simple
        RoomBooking booking = new RoomBookingBuilder(bus)
                .reservationNumber("RES-0001")
                .start(LocalDateTime.now().plusDays(1))
                .durationDays(2)
                .guest(guest)
                .room(chosen)
                .advance(50.0)
                .build();

        booking.confirm(); // triggers observers (SMS + Email)

        // --- Strategy + Template + Proxy for payment ---
        PaymentGateway gw = new PaymentGatewayProxy(new RealPaymentGateway(), "API-KEY-123");
        PaymentStrategy payWithCard = new CreditCardPayment("tok_abc123", gw); // DI of gateway
        boolean paid = payWithCard.pay(booking.invoice.amount > 0 ? booking.invoice.amount : 350.0);
        System.out.println("Payment success? " + paid);

        // --- Check-in/out demo on Room ---
        chosen.checkIn();
        chosen.checkOut();
    }
}