package org.example.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LockerLocation {
    private String name;
    private final List<Locker> lockers = new ArrayList<>();
    private double latitude;
    private double longitude;
    private LocalTime openTime;
    private LocalTime closeTime;

    public LockerLocation(String name, double latitude, double longitude,
                          LocalTime openTime, LocalTime closeTime) {
        this.name = Objects.requireNonNull(name);
        this.latitude = latitude;
        this.longitude = longitude;
        this.openTime = Objects.requireNonNull(openTime);
        this.closeTime = Objects.requireNonNull(closeTime);
    }

    public void addLocker(Locker locker) {
        lockers.add(Objects.requireNonNull(locker));
    }

    public String getName() {
        return name;
    }

    public List<Locker> getLockers() {
        return List.copyOf(lockers);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }
}
