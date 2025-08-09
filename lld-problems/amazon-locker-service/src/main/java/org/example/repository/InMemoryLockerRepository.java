package org.example.repository;

import org.example.entity.Locker;
import org.example.entity.LockerLocation;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLockerRepository implements LockerRepository {
    private final Map<String, Locker> lockers = new ConcurrentHashMap<>();
    private final Map<String, LockerLocation> locations = new ConcurrentHashMap<>();

    @Override
    public Optional<Locker> findById(String lockerId) {
        return Optional.ofNullable(lockers.get(lockerId));
    }

    @Override
    public List<Locker> findByLocationId(String locationId) {
        return lockers.values().stream().filter(l -> l.getLocationId().equals(locationId)).toList();
    }

    @Override
    public List<Locker> findAll() {
        return new ArrayList<>(lockers.values());
    }

    @Override
    public void saveLocker(Locker locker) {
        lockers.put(locker.getLockerId(), locker);
    }

    @Override
    public void saveLocation(LockerLocation location) {
        locations.put(location.getName(), location);
    }

    @Override
    public double locationLat(String locationId) {
        return locations.get(locationId).getLatitude();
    }

    @Override
    public double locationLon(String locationId) {
        return locations.get(locationId).getLongitude();
    }

    @Override
    public Collection<LockerLocation> allLocations() {
        return locations.values();
    }
}
