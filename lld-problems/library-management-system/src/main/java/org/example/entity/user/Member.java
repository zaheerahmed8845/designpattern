package org.example.entity.user;

import org.example.entity.BookObserver;
import org.example.entity.book.BookItem;
import org.example.entity.book.BookLending;
import org.example.entity.book.BookReservation;

import java.time.LocalDateTime;

public class Member extends User implements BookObserver {
    private LocalDateTime dateOfMembership;
    private int totalBooksCheckedOut;

    public int getTotalBooksCheckedOut() {
        return totalBooksCheckedOut;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        // Create reservation (ONE-WAY: User knows reservation; reservation knows BookItem)
        BookReservation reservation = new BookReservation(bookItem, this.id);
        relatedReservations.add(reservation);
        // Optionally observe availability
        bookItem.registerObserver(this);
        return true;
    }

    public void checkoutBookItem(BookItem bookItem) {
        if (bookItem.isReferenceOnly()) {
            throw new IllegalStateException("Reference-only item cannot be checked out");
        }
        // Create lending record (ONE-WAY: Lending -> BookItem)
        BookLending lending = new BookLending(bookItem, this.id, LocalDateTime.now(), LocalDateTime.now().plusDays(15));
        // Track association from User side only
        relatedBookItems.add(bookItem);
        totalBooksCheckedOut++;
        bookItem.checkout(this.id);
    }

    public void returnBookItem(BookItem bookItem) {
        totalBooksCheckedOut = Math.max(0, totalBooksCheckedOut - 1);
        bookItem.setAvailable();
    }

    public void renewBookItem(BookItem bookItem) {
        // renewal logic would update corresponding lending record in persistence
    }

    public void checkForFine(String bookItemId) { /* calculate fines if overdue */ }

    @Override
    public void onBookAvailable(BookItem bookItem) {
        System.out.println("Notify member " + id + ": '" + bookItem.getTitle() + "' is now available.");
    }
}
