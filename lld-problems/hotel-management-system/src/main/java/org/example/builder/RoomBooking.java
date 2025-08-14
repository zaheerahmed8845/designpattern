package org.example.builder;

import org.example.entity.Invoice;
import org.example.entity.Room;
import org.example.entity.RoomBookingEvent;
import org.example.enums.BookingStatus;
import org.example.observer.BookingEventBus;
import org.example.person.Guest;
import org.example.service.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomBooking {
    public String reservationNumber;
    public LocalDateTime startDate;
    public int durationDays;
    public BookingStatus status = BookingStatus.Requested;
    public LocalDateTime createdOn = LocalDateTime.now(), checkin, checkout;
    public Guest guest;
    public Room room;
    public final List<Service> services = new ArrayList<>();
    public double advancePayment;
    public Invoice invoice = new Invoice();
    private final BookingEventBus bus;

    RoomBooking(BookingEventBus bus) {
        this.bus = bus;
    }

    public RoomBooking fetchDetails() {
        return this;
    }

    public void confirm() {
        status = BookingStatus.Confirmed;
        bus.publish(new RoomBookingEvent(reservationNumber, "Booking Confirmed: " + reservationNumber, guest));
    }
}
