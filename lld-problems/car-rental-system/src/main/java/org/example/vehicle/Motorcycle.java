package org.example.vehicle;

import org.example.enums.MotorcycleType;
import org.example.enums.VehicleStatus;

public class Motorcycle extends Vehicle {
    private MotorcycleType type;

    public Motorcycle(int vehicleId, String licensePlateNumber, int passengerCapacity, VehicleStatus status, String model, int manufacturingYear, MotorcycleType type) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.type = type;
    }

    public MotorcycleType getType() {
        return type;
    }

    @Override
    public String getTypeKey() {
        return type.name();
    }
}
