package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRentalBranch {
    private String name;
    private Address address;
    private final List<ParkingStall> parkingStalls = new ArrayList<>();

    public CarRentalBranch(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getLocation() {
        return address;
    }

    public void addParkingStall(ParkingStall stall) {
        this.parkingStalls.add(stall);
    }

    public List<ParkingStall> getParkingStalls() {
        return Collections.unmodifiableList(parkingStalls);
    }

    public String getName() {
        return name;
    }
}
