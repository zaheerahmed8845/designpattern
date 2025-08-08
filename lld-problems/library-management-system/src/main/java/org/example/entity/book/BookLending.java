package org.example.entity.book;

import org.example.entity.notification.Notification;
import org.example.entity.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookLending {
    private final BookItem bookItem;
    private User user;
    private final LocalDateTime creationDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private BookReservation reservation;
    private final List<Notification> notifications = new ArrayList<>();

    public BookLending(BookItem bookItem, User user, LocalDateTime creationDate, LocalDateTime dueDate) {
        this.bookItem = bookItem;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        linkUser(user);
    }

    public void markReturned() {
        this.returnDate = LocalDateTime.now();
    }

    public void linkUser(User u) {
        if (this.user != u) {
            this.user = u;
            if (u != null) u.linkLending(this);
        }
    }

    void linkReservation(BookReservation r) {
        if (this.reservation != r) {
            this.reservation = r;
            if (r != null) r.linkLending(this);
        }
    }

    public void linkNotification(Notification n) {
        if (!notifications.contains(n)) {
            notifications.add(n);
            n.linkLending(this);
        }
    }
}
