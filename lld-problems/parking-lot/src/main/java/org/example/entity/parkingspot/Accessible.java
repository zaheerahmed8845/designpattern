package org.example.entity.parkingspot;

import org.example.entity.vehicle.Vehicle;

public class Accessible extends ParkingSpot {
    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
        return true;
    }
}
