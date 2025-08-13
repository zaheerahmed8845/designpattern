package org.example.factory;

import org.example.enums.MotorcycleType;
import org.example.vehicle.Motorcycle;
import org.example.vehicle.Vehicle;

public class MotorcycleFactory extends VehicleFactory {
    private final MotorcycleType type;

    public MotorcycleFactory(MotorcycleType type) {
        this.type = type;
    }

    @Override
    public Vehicle create(VehicleSpec s) {
        return new Motorcycle(s.vehicleId, s.licensePlateNumber, s.passengerCapacity, s.status, s.model, s.manufacturingYear, type);
    }
}
