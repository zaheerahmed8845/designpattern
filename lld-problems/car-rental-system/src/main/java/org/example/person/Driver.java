package org.example.person;

public class Driver extends Person {
    private int driverId;

    public Driver(int driverId) {
        this.driverId = driverId;
    }

    public int getDriverId() {
        return driverId;
    }
}
