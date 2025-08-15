package org.example.entity;

import org.example.enums.TableStatus;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int tableId;
    private TableStatus status;
    private int maxCapacity;
    private String locationIdentifier;
    private int numberOfSeats;
    private final List<Reservation> reservations = new ArrayList<>();

    public Table(int tableId, int maxCapacity, String locationIdentifier, int numberOfSeats) {
        this.tableId = tableId;
        this.maxCapacity = maxCapacity;
        this.locationIdentifier = locationIdentifier;
        this.numberOfSeats = numberOfSeats;
        this.status = TableStatus.FREE;
    }

    public boolean addReservation(Reservation r) {
        return reservations.add(r);
    }

    public List<Table> search() {
        return List.of(this);
    }
}
