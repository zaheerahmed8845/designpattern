package org.example.entity.book;

import org.example.enums.ReservationStatus;

import java.time.LocalDateTime;

public class BookReservation {
    // ONE-WAY: BookReservation -> BookItem (holds reference), plus memberId for who reserved
    private final BookItem bookItem;
    private final String memberId;

    private final LocalDateTime creationDate = LocalDateTime.now();
    private ReservationStatus status = ReservationStatus.WAITING;

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
}
