package org.example.repository;

import org.example.entity.Locker;
import org.example.entity.LockerLocation;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface LockerRepository {
    Optional<Locker> findById(String lockerId);

    List<Locker> findByLocationId(String locationId);

    List<Locker> findAll();

    void saveLocker(Locker locker);

    void saveLocation(LockerLocation location);

    // convenience for geo-aware strategies
    double locationLat(String locationId);

    double locationLon(String locationId);

    Collection<LockerLocation> allLocations();
}
