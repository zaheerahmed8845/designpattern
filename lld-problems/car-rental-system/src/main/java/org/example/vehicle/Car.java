package org.example.vehicle;

import org.example.enums.CarType;
import org.example.enums.VehicleStatus;

public class Car extends Vehicle {
    private CarType type;

    public Car(int vehicleId, String licensePlateNumber, int passengerCapacity, VehicleStatus status, String model, int manufacturingYear, CarType type) {
        super(vehicleId, licensePlateNumber, passengerCapacity, status, model, manufacturingYear);
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public String getTypeKey() {
        return type.name();
    }
}
