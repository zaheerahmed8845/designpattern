package org.example.entity.parkingspot;

import org.example.entity.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingSpot {
    public int id;
    public boolean isFree = true;
    Vehicle vehicle;
    private final List<ParkingSpotObserver> observers = new ArrayList<>();

    public ParkingSpot(int id) {
        this.id = id;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (!isFree) return false;
        this.vehicle = vehicle;
        this.isFree = false;
        notifyObservers();
        return true;
    }

    public boolean removeVehicle() {
        if (isFree) return false;
        this.vehicle = null;
        this.isFree = true;
        notifyObservers();
        return true;
    }

    public void addObserver(ParkingSpotObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ParkingSpotObserver observer : observers) {
            observer.onSpotStatusChange();
        }
    }
}
