package org.example.entity.user;

import org.example.entity.LibraryCard;
import org.example.entity.Person;
import org.example.entity.book.BookItem;
import org.example.entity.book.BookReservation;
import org.example.enums.AccountStatus;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    public String id;
    protected String password;
    public AccountStatus status;
    public Person person;
    protected LibraryCard card;

    // ONE-WAY ASSOCIATIONS (User -> BookItem, User -> BookReservation)
    // Users can hold references to items they interact with, and their reservations.
    protected final List<BookItem> relatedBookItems = new ArrayList<>();
    protected final List<BookReservation> relatedReservations = new ArrayList<>();

    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

    // accessors for one-way associations
    public List<BookItem> getRelatedBookItems() {
        return relatedBookItems;
    }

    public List<BookReservation> getRelatedReservations() {
        return relatedReservations;
    }
}
