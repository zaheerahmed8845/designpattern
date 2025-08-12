package org.example.entity;

import org.example.enums.BookingStatus;
import org.example.payment.Payment;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int bookingId, amount, totalSeat;
    private OffsetDateTime createdOn = OffsetDateTime.now();
    private BookingStatus status = BookingStatus.PENDING;
    private Payment payment;
    private ShowTime showTime;
    private Customer customer;
    private final List<MovieTicket> tickets = new ArrayList<>();

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int v) {
        bookingId = v;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int v) {
        amount = v;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int v) {
        totalSeat = v;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus v) {
        status = v;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment v) {
        payment = v;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime v) {
        showTime = v;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer v) {
        customer = v;
    }

    public List<MovieTicket> getTickets() {
        return tickets;
    }

    public boolean confirmBooking() {
        this.status = BookingStatus.CONFIRMED;
        return true;
    }

    public boolean cancelBooking() {
        this.status = BookingStatus.CANCELED;
        return true;
    }

    // -------- Builder --------
    public static class Builder {
        private final Booking b = new Booking();

        public Builder id(int id) {
            b.setBookingId(id);
            return this;
        }

        public Builder customer(Customer c) {
            b.setCustomer(c);
            return this;
        }

        public Builder show(ShowTime s) {
            b.setShowTime(s);
            return this;
        }

        public Builder seats(int count) {
            b.setTotalSeat(count);
            return this;
        }

        public Builder amount(int amt) {
            b.setAmount(amt);
            return this;
        }

        public Builder ticket(MovieTicket t) {
            b.getTickets().add(t);
            return this;
        }

        public Builder payment(Payment p) {
            b.setPayment(p);
            return this;
        }

        public Booking build() {
            return b;
        }
    }
}
