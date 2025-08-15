package org.example.entity;

import org.example.enums.ReservationStatus;
import org.example.person.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private final String reservationId;
    private final LocalDateTime timeOfReservation;
    private LocalDateTime checkinTime;
    private ReservationStatus status;
    private int peopleCount;
    private final Customer customer;
    private final List<Table> tables = new ArrayList<>();
    private final List<Notification> notifications = new ArrayList<>();
    private final String notes;

    private Reservation(Builder b) {
        this.reservationId = b.reservationId;
        this.timeOfReservation = b.timeOfReservation;
        this.status = b.status;
        this.peopleCount = b.peopleCount;
        this.customer = b.customer;
        this.tables.addAll(b.tables);
        this.notes = b.notes;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void updatePeopleCount(int count) {
        this.peopleCount = count;
    }

    public void addTable(Table t) {
        this.tables.add(t);
    }

    public void addNotification(Notification n) {
        this.notifications.add(n);
    }

    public void checkIn(LocalDateTime time) {
        this.checkinTime = time;
        this.status = ReservationStatus.CHECKEDIN;
    }

    public static class Builder {
        private String reservationId;
        private LocalDateTime timeOfReservation;
        private ReservationStatus status = ReservationStatus.REQUESTED;
        private int peopleCount;
        private Customer customer;
        private final List<Table> tables = new ArrayList<>();
        private String notes = "";

        public Builder id(String id) {
            this.reservationId = id;
            return this;
        }

        public Builder at(LocalDateTime time) {
            this.timeOfReservation = time;
            return this;
        }

        public Builder forPeople(int count) {
            this.peopleCount = count;
            return this;
        }

        public Builder by(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder addTable(Table table) {
            this.tables.add(table);
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder status(ReservationStatus status) {
            this.status = status;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }
}
