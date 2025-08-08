package org.example.entity.notification;

import org.example.entity.book.BookLending;
import org.example.entity.book.BookReservation;

import java.time.LocalDateTime;

public abstract class Notification {
    private String notificationId;
    private LocalDateTime created = LocalDateTime.now();
    private String content;
    private BookLending lending;
    private BookReservation reservation;

    public boolean sendNotification() {
        return true;
    }

    public void linkLending(BookLending l) {
        if (this.lending != l) {
            this.lending = l;
            if (l != null) l.linkNotification(this);
        }
    }

    public void linkReservation(BookReservation r) {
        if (this.reservation != r) {
            this.reservation = r;
            if (r != null) r.linkNotification(this);
        }
    }
}
