package org.example.entity;

import java.util.Objects;

public class Package {
    private String packageId;
    private double packageSize; // cubic volume or mapped score
    private Order order;

    public Package(String packageId, double packageSize, Order order) {
        this.packageId = Objects.requireNonNull(packageId);
        this.packageSize = packageSize;
        this.order = Objects.requireNonNull(order);
    }

    public void pack() {
        // TODO: packing logic if needed
    }

    public String getPackageId() {
        return packageId;
    }

    public double getPackageSize() {
        return packageSize;
    }

    public Order getOrder() {
        return order;
    }
}

