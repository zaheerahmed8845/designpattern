package org.example;

import org.example.entity.*;
import org.example.entity.seat.SeatFactory;
import org.example.enums.SeatStatus;
import org.example.notification.NotificationService;
import org.example.payment.CreditCard;
import org.example.payment.Payment;
import org.example.payment.PaymentFactory;
import org.example.pricing.PricingContext;
import org.example.pricing.PricingEngine;
import org.example.search.Catalog;

import java.time.*;

public class AppMain {
    public static void main(String[] args) {
        // Catalog (Singleton)
        Catalog catalog = Catalog.getInstance();
        Movie movie = new Movie();
        movie.setTitle("Interstellar");
        movie.setGenre("Sci-Fi");
        movie.setLanguage("EN");
        movie.setReleaseDate(LocalDate.now());
        movie.setDuration(Duration.ofMinutes(169));
        catalog.add(movie);

        // City / Cinema / Hall
        City city = new City();
        city.setCityId(1);
        city.setName("Bangalore");
        city.setState("KA");
        city.setZipCode("560001");
        Cinema cinema = new Cinema();
        cinema.setCinemaId(101);
        cinema.setName("CineMax");
        Address addr = new Address();
        addr.setLine1("MG Road");
        addr.setCity("Bangalore");
        addr.setCountry("India");
        cinema.setAddress(addr);
        cinema.setCity(city);
        city.getCinemas().add(cinema);
        Hall hall = new Hall();
        hall.setHallId(9);
        hall.setName("Hall-9");
        hall.getSeats().add(SeatFactory.create("PLATINUM", "A12", 350));
        hall.getSeats().add(SeatFactory.create("GOLD", "A11", 300));
        hall.getSeats().add(SeatFactory.create("SILVER", "A10", 250));
        cinema.getHalls().add(hall);

        // Show
        ShowTime show = new ShowTime();
        show.setShowId(1001);
        show.setMovie(movie);
        show.setHall(hall);
        show.setDate(LocalDateTime.now());
        show.setStartTime(LocalDateTime.now().withHour(20).withMinute(0));
        show.setDurationMinutes(170);
        show.getSeatStatuses().put("A10", SeatStatus.AVAILABLE);
        show.getSeatStatuses().put("A11", SeatStatus.AVAILABLE);
        show.getSeatStatuses().put("A12", SeatStatus.AVAILABLE);

        // Admin
        Admin admin = new Admin();
        admin.setName("AdminUser");
        admin.addMovie(movie);
        admin.addShow(show);

        // Customer
        Customer cust = new Customer();
        cust.setName("Zaheer");
        cust.setEmail("user@example.com");
        cust.setPhone("+911234567890");

        // Strategy: Pricing
        PricingEngine engine = new PricingEngine();
        PricingContext ctx = new PricingContext("PLATINUM", DayOfWeek.FRIDAY, LocalTime.of(20, 0), 250.0, 0.85);
        double fare = engine.quote(ctx);

        // Factory: Payment
        Payment payment = PaymentFactory.of("CARD");
        if (payment instanceof CreditCard cc) {
            cc.setNameOnCard("Zaheer Ahmed");
            cc.setCardNumber("4111111111111111");
            cc.setCvv("123");
            cc.setAmount(fare);
        }
        boolean paid = payment.makePayment();

        // Builder: Booking
        MovieTicket ticket = new MovieTicket();
        ticket.setTicketId(90001);
        ticket.setMovie(movie);
        ticket.setShow(show);
        Booking booking = new Booking.Builder().id(5001).customer(cust).show(show).seats(1).amount((int) fare).ticket(ticket).payment(payment).build();
        if (paid) booking.confirmBooking();

        // Notification Facade
        NotificationService notifier = new NotificationService();
        if (paid) notifier.sendBookingConfirmed(cust, String.valueOf(booking.getBookingId()), fare);
        else notifier.sendBookingFailed(cust, String.valueOf(booking.getBookingId()));
        System.out.println("Booking status: " + booking.getStatus());
    }
}
