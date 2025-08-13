package org.example.entity;

public class ParkingStall {
    private int stallId;
    private String locationIdentifier;

    public ParkingStall(int stallId, String locationIdentifier) {
        this.stallId = stallId;
        this.locationIdentifier = locationIdentifier;
    }

    public int getStallId() {
        return stallId;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }
}
