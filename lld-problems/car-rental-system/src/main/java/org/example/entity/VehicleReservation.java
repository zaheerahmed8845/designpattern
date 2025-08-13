package org.example.entity;

import org.example.enums.ReservationStatus;
import org.example.equipment.Equipment;
import org.example.service.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VehicleReservation {
    private int reservationId;
    private String customerId;
    private int vehicleId;
    private LocalDateTime createdOn;
    private ReservationStatus status;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private String pickupLocation;
    private String returnLocation;
    private final List<Equipment> equipments = new ArrayList<>();
    private final List<Service> services = new ArrayList<>();
    private Fine fine;

    public VehicleReservation(int reservationId, String customerId, int vehicleId, LocalDateTime startDate,
                              LocalDateTime dueDate, String pickupLocation, String returnLocation) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.createdOn = LocalDateTime.now();
        this.status = ReservationStatus.Pending;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
    }

    public VehicleReservation getReservationDetails() {
        return this;
    }

    public boolean addEquipment(Equipment equipment) {
        return equipments.add(equipment);
    }

    public boolean addService(Service service) {
        return services.add(service);
    }

    public List<Equipment> getEquipments() {
        return Collections.unmodifiableList(equipments);
    }

    public List<Service> getServices() {
        return Collections.unmodifiableList(services);
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public Optional<Fine> getFine() {
        return Optional.ofNullable(fine);
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }
}
