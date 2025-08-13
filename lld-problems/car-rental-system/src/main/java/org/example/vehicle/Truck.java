package org.example.vehicle;

import org.example.enums.TruckType;
import org.example.enums.VehicleStatus;

public class Truck extends Vehicle {
    private TruckType type;

    public Truck(int vehicleId, String licensePlateNumber, int passengerCapacity, VehicleStatus status, String model, int manufacturingYear, TruckType type) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.type = type;
    }

    public TruckType getType() {
        return type;
    }

    @Override
    public String getTypeKey() {
        return type.name();
    }
}
