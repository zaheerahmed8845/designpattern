package org.example.entity.user;

import org.example.entity.BookObserver;
import org.example.entity.book.BookItem;
import org.example.entity.book.BookLending;
import org.example.entity.book.BookReservation;

import java.time.LocalDateTime;

public class Member extends User implements BookObserver {
    private LocalDateTime dateOfMembership;
    private int totalBooksCheckedOut;

    public boolean reserveBookItem(BookItem bookItem) {
        BookReservation reservation = new BookReservation(bookItem, this.id);
        relatedReservations.add(reservation);
        bookItem.registerObserver(this);
        return true;
    }

    public void checkoutBookItem(BookItem bookItem) {
        if (bookItem.isReferenceOnly()) throw new IllegalStateException("Reference-only item cannot be checked out");
        BookLending lending = new BookLending(bookItem, this, LocalDateTime.now(), LocalDateTime.now().plusDays(15));
        this.linkLending(lending);
        relatedBookItems.add(bookItem);
        totalBooksCheckedOut++;
        bookItem.checkout(this.id);
    }

    public void returnBookItem(BookItem bookItem) {
        totalBooksCheckedOut = Math.max(0, totalBooksCheckedOut - 1);
        bookItem.setAvailable();
    }

    public void renewBookItem(BookItem bookItem) {
    }

    public void checkForFine(String bookItemId) {
    }

    @Override
    public void onBookAvailable(BookItem bookItem) {
        System.out.println("Notify member " + id + ": '" + bookItem.getTitle() + "' is now available.");
    }
}
