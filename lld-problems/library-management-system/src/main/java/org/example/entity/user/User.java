package org.example.entity.user;

import org.example.entity.LibraryCard;
import org.example.entity.Person;
import org.example.entity.book.BookItem;
import org.example.entity.book.BookLending;
import org.example.entity.book.BookReservation;
import org.example.enums.AccountStatus;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    public String id;
    protected String password;
    public AccountStatus status;
    public Person person;
    protected final LibraryCard card = new LibraryCard(); // Composition: User composed of LibraryCard

    protected final List<BookItem> relatedBookItems = new ArrayList<>(); // One-way
    protected final List<BookReservation> relatedReservations = new ArrayList<>(); // One-way
    protected final List<BookLending> borrowings = new ArrayList<>(); // Two-way with BookLending

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    public List<BookItem> getRelatedBookItems() {
        return relatedBookItems;
    }

    public List<BookReservation> getRelatedReservations() {
        return relatedReservations;
    }

    public List<BookLending> getBorrowings() {
        return borrowings;
    }

    public void linkLending(BookLending lending) {
        if (!borrowings.contains(lending)) {
            borrowings.add(lending);
            lending.linkUser(this);
        }
    }
}