package org.example.vehicle;

import org.example.enums.VanType;
import org.example.enums.VehicleStatus;

public class Van extends Vehicle {
    private VanType type;

    public Van(int vehicleId, String licensePlateNumber, int passengerCapacity, VehicleStatus status, String model, int manufacturingYear, VanType type) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.type = type;
    }

    public VanType getType() {
        return type;
    }

    @Override
    public String getTypeKey() {
        return type.name();
    }
}
