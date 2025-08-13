package org.example.factory;

import org.example.enums.VanType;
import org.example.vehicle.Van;
import org.example.vehicle.Vehicle;

public class VanFactory extends VehicleFactory {
    private final VanType type;

    public VanFactory(VanType type) {
        this.type = type;
    }

    @Override
    public Vehicle create(VehicleSpec s) {
        return new Van(s.vehicleId, s.licensePlateNumber, s.passengerCapacity, s.status, s.model, s.manufacturingYear, type);
    }
}
