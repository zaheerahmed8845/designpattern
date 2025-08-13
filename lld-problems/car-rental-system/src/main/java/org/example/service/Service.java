package org.example.service;

public abstract class Service {
    private int serviceId;
    private int price; // minor units

    public Service(int serviceId, int price) {
        this.serviceId = serviceId;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getPrice() {
        return price;
    }
}
