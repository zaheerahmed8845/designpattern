package org.example.factory;

import org.example.enums.CarType;
import org.example.vehicle.Car;
import org.example.vehicle.Vehicle;

public class CarFactory extends VehicleFactory {
    private final CarType type;

    public CarFactory(CarType type) {
        this.type = type;
    }

    @Override
    public Vehicle create(VehicleSpec s) {
        return new Car(s.vehicleId, s.licensePlateNumber, s.passengerCapacity, s.status, s.model, s.manufacturingYear, type);
    }
}