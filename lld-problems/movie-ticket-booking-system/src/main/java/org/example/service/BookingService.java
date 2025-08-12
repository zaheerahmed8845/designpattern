package org.example.service;

import org.example.enums.BookingStatus;
import org.example.notification.NotificationService;
import org.example.payment.Payment;
import org.example.payment.PaymentFactory;
import org.example.repository.BookingRepository;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private final SeatLockingService locks;
    private final BookingRepository repo;
    private final NotificationService notifier;

    public BookingService(SeatLockingService locks, BookingRepository repo, NotificationService notifier) {
        this.locks = locks;
        this.repo = repo;
        this.notifier = notifier;
    }

    /**
     * One-shot flow: lock → pay → persist → notify. In production, payment is async via webhooks.
     */
    public Booking placeOrder(String userId, String email, String phone,
                              String showId, List<String> seatIds,
                              double amount, String paymentMethod, String paymentRef) {
        String bookingId = UUID.randomUUID().toString();
        // 1) lock seats (soft lock with TTL)
        boolean locked = locks.lock(showId, seatIds, bookingId, Duration.ofMinutes(10));
        if (!locked) throw new IllegalStateException("Seat(s) unavailable.");

        try {
            // 2) take payment
            Payment p = PaymentFactory.of(paymentMethod, paymentRef);
            boolean paid = p.make(amount);
            if (!paid) {
                notifier.bookingFailed(email, phone, bookingId);
                throw new IllegalStateException("Payment failed");
            }

            // 3) final persist with uniqueness (DB guard)
            boolean persisted = repo.tryPersistSeats(showId, seatIds, bookingId);
            if (!persisted) {
                notifier.bookingFailed(email, phone, bookingId);
                throw new IllegalStateException("Seats already taken");
            }

            // 4) success → notify
            notifier.bookingConfirmed(email, phone, bookingId, amount);

            Booking b = new Booking(bookingId, userId, showId, seatIds, amount);
            b.status = BookingStatus.CONFIRMED;
            return b;

        } finally {
            // 5) release seats regardless of outcome
            locks.release(showId, seatIds, bookingId);
        }
    }
}