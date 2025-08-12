package org.example.seat;

import org.example.enums.SeatStatus;

public abstract class Seat {
    private final String id;
    private final String label; // e.g., A10
    private volatile SeatStatus status = SeatStatus.AVAILABLE;
    private double baseRate;

    protected Seat(String id, String label, double baseRate) {
        this.id = id;
        this.label = label;
        this.baseRate = baseRate;
    }

    public String id() {
        return id;
    }

    public String label() {
        return label;
    }

    public SeatStatus status() {
        return status;
    }

    public void status(SeatStatus s) {
        this.status = s;
    }

    public double baseRate() {
        return baseRate;
    }

    public void baseRate(double r) {
        this.baseRate = r;
    }

    public abstract String type();
}
