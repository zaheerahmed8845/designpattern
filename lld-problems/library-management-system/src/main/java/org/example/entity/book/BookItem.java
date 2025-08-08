package org.example.entity.book;

import org.example.entity.BookObserver;
import org.example.entity.Rack;
import org.example.enums.BookStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookItem extends Book {
    private String itemId;
    private boolean isReferenceOnly;
    private LocalDateTime borrowed;
    private LocalDateTime dueDate;
    private double price;
    private BookStatus status;
    private LocalDateTime dateOfPurchase;
    private Rack placedAt;

    // Observers (not Users; Users subscribe, but BookItem does not hold a User reference)
    private final List<BookObserver> observers = new ArrayList<>();

    public boolean checkout(String memberId) {
        this.borrowed = LocalDateTime.now();
        this.dueDate = borrowed.plusDays(15);
        this.status = BookStatus.LOANED;
        return true;
    }

    public void setAvailable() {
        this.status = BookStatus.AVAILABLE;
        notifyObservers();
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void registerObserver(BookObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        observers.forEach(o -> o.onBookAvailable(this));
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }
}