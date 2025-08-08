package org.example.entity.book;

import java.time.LocalDateTime;

public class BookLending {
    // ONE-WAY: BookLending -> BookItem (holds reference), plus memberId for who borrowed
    private final BookItem bookItem;
    private final String memberId;

    private final LocalDateTime creationDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    public BookLending(BookItem bookItem, String memberId, LocalDateTime creationDate, LocalDateTime dueDate) {
        this.bookItem = bookItem;
        this.memberId = memberId;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public void markReturned() {
        this.returnDate = LocalDateTime.now();
    }
}
