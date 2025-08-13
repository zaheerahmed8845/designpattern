package org.example.vehicle;

import org.example.entity.VehicleLog;
import org.example.enums.VehicleStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Vehicle {
    private int vehicleId;
    private String licensePlateNumber;
    private int passengerCapacity;
    private VehicleStatus status;
    private String model;
    private int manufacturingYear;
    private final List<VehicleLog> logs = new ArrayList<>();

    public Vehicle(int vehicleId, String licensePlateNumber, int passengerCapacity, VehicleStatus status, String model, int manufacturingYear) {
        this.vehicleId = vehicleId;
        this.licensePlateNumber = licensePlateNumber;
        this.passengerCapacity = passengerCapacity;
        this.status = status;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
    }

    public boolean reserveVehicle() {
        if (status == VehicleStatus.Available) {
            status = VehicleStatus.Reserved;
            return true;
        }
        return false;
    }

    public boolean returnVehicle() {
        status = VehicleStatus.Available;
        return true;
    }

    public void addLog(VehicleLog log) {
        logs.add(log);
    }

    public List<VehicleLog> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public abstract String getTypeKey();
}
