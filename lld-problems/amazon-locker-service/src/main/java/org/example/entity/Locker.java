package org.example.entity;


import org.example.enums.LockerSize;
import org.example.enums.LockerState;

import java.util.Objects;

public class Locker {
    private String lockerId;
    private LockerSize lockerSize;
    private String locationId;          // could reference LockerLocation name/id
    private LockerState lockerState = LockerState.AVAILABLE;
    private LockerPackage currentPackage;

    public Locker(String lockerId, LockerSize size, String locationId) {
        this.lockerId = Objects.requireNonNull(lockerId);
        this.lockerSize = Objects.requireNonNull(size);
        this.locationId = Objects.requireNonNull(locationId);
    }

    public boolean addPackage(LockerPackage pkg) {
        if (lockerState != LockerState.AVAILABLE || currentPackage != null) return false;
        this.currentPackage = Objects.requireNonNull(pkg);
        this.lockerState = LockerState.BOOKED;
        return true;
    }

    public boolean removePackage() {
        if (currentPackage == null) return false;
        this.currentPackage = null;
        this.lockerState = LockerState.AVAILABLE;
        return true;
    }

    public String getLockerId() {
        return lockerId;
    }

    public LockerSize getLockerSize() {
        return lockerSize;
    }

    public String getLocationId() {
        return locationId;
    }

    public LockerState getLockerState() {
        return lockerState;
    }

    public LockerPackage getCurrentPackage() {
        return currentPackage;
    }
}