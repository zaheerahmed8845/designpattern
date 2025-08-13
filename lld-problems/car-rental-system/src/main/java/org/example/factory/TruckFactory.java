package org.example.factory;

import org.example.enums.TruckType;
import org.example.vehicle.Truck;
import org.example.vehicle.Vehicle;

public class TruckFactory extends VehicleFactory {
    private final TruckType type;

    public TruckFactory(TruckType type) {
        this.type = type;
    }

    @Override
    public Vehicle create(VehicleSpec s) {
        return new Truck(s.vehicleId, s.licensePlateNumber, s.passengerCapacity, s.status, s.model, s.manufacturingYear, type);
    }
}
