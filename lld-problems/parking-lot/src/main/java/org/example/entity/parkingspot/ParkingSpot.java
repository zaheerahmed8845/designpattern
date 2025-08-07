package org.example.entity.parkingspot;

import org.example.entity.vehicle.Vehicle;

public abstract class ParkingSpot {
    public int id;
    public boolean isFree;
    Vehicle vehicle;

    public abstract boolean assignVehicle(Vehicle vehicle);

    public abstract boolean removeVehicle();
}
