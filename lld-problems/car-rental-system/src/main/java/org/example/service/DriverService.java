package org.example.service;

public class DriverService extends Service {
    private int driverId;

    public DriverService(int serviceId, int price, int driverId) {
        super(serviceId, price);
        this.driverId = driverId;
    }

    public int getDriverId() {
        return driverId;
    }
}
