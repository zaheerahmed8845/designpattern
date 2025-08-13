package org.example.person;

import org.example.entity.VehicleReservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer extends Account {
    private String licenseNumber;
    private LocalDate licenseExpiry;
    private final List<VehicleReservation> reservations = new ArrayList<>();

    public Customer(String accountId, String password, String licenseNumber, LocalDate licenseExpiry) {
        super(accountId, password);
        this.licenseNumber = licenseNumber;
        this.licenseExpiry = licenseExpiry;
    }

    public boolean addReservation(VehicleReservation r) {
        return reservations.add(r);
    }

    public boolean cancelReservation(int reservationId) {
        return reservations.removeIf(r -> r.getReservationId() == reservationId);
    }

    public List<VehicleReservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public LocalDate getLicenseExpiry() {
        return licenseExpiry;
    }
}
