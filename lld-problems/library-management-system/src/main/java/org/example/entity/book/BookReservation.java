package org.example.entity.book;

import org.example.entity.notification.Notification;
import org.example.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookReservation {
    private final BookItem bookItem; // One-way
    private final String memberId;
    private final LocalDateTime creationDate = LocalDateTime.now();
    private ReservationStatus status = ReservationStatus.WAITING;
    private BookLending lending;
    private final List<Notification> notifications = new ArrayList<>();

    public BookReservation(BookItem bookItem, String memberId) {
        this.bookItem = bookItem;
        this.memberId = memberId;
    }

    public void markReserved() {
        this.status = ReservationStatus.RESERVED;
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELED;
    }

    void linkLending(BookLending l) {
        if (this.lending != l) {
            this.lending = l;
            if (l != null) l.linkReservation(this);
        }
    }

    public void linkNotification(Notification n) {
        if (!notifications.contains(n)) {
            notifications.add(n);
            n.linkReservation(this);
        }
    }
}