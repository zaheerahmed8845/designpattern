package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private String orderId;
    private final List<Item> items = new ArrayList<>();
    private String deliveryLocation;
    private String customerId;

    public Order(String orderId, String deliveryLocation, String customerId) {
        this.orderId = Objects.requireNonNull(orderId);
        this.deliveryLocation = Objects.requireNonNull(deliveryLocation);
        this.customerId = Objects.requireNonNull(customerId);
    }

    public void addItem(Item item) {
        items.add(Objects.requireNonNull(item));
    }

    public String getOrderId() {
        return orderId;
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public String getCustomerId() {
        return customerId;
    }
}
