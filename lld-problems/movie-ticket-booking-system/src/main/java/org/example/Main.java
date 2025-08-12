package org.example;

import org.example.entity.Movie;
import org.example.entity.PricingContext;
import org.example.entity.ShowTime;
import org.example.notification.NotificationService;
import org.example.price.PricingEngine;
import org.example.repository.InMemoryBookingRepository;
import org.example.seat.SeatFactory;
import org.example.service.BookingService;
import org.example.service.InMemorySeatLockingService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a movie, show, and some seats
        Movie movie = new Movie("m1", "Interstellar", "EN", "Sci-Fi", 169);
        ShowTime show = new ShowTime("show-1", movie, LocalDate.now(), LocalTime.of(20, 0));
        show.addSeat(SeatFactory.create("PLATINUM", "s1", "A10", 250));
        show.addSeat(SeatFactory.create("PLATINUM", "s2", "A11", 250));
        show.addSeat(SeatFactory.create("GOLD", "s3", "B10", 220));

        // Price one seat using Strategy
        var engine = new PricingEngine();
        var ctx = new PricingContext(show.id(), "PLATINUM", DayOfWeek.FRIDAY, show.start(), 250.0, 0.85);
        double fare = engine.quote(ctx);

        // Wire services
        var locks = new InMemorySeatLockingService();
        var repo = new InMemoryBookingRepository();
        var notifier = new NotificationService();
        var bookingService = new BookingService(locks, repo, notifier);

        // Try to place an order for seat s1
        var booking = bookingService.placeOrder(
                "user-123", "user@example.com", "+911234567890",
                show.id(), List.of("s1"), fare, "CARD", "tok_abc");

        System.out.println("Booking ID: " + booking.id + ", status=" + booking.status);

        // Try a conflicting order (same seat) to see guard in action
        try {
            bookingService.placeOrder(
                    "user-999", "x@example.com", "+910000000000",
                    show.id(), List.of("s1"), fare, "CARD", "tok_xyz");
        } catch (Exception e) {
            System.out.println("Second attempt failed as expected: " + e.getMessage());
        }
    }
}