package org.example.entity;

import org.example.enums.ShipmentStatus;

import java.time.Instant;

public class Shipment {
    private String shipmentNumber;
    private Instant shipmentDate;
    private Instant estimatedArrival;
    private String shipmentMethod;
    private ShipmentStatus status = ShipmentStatus.Pending;

    // getters/setters
}
