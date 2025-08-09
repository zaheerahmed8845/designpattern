package org.example.repository;

import org.example.entity.LockerPackage;

import java.util.Optional;

public interface PackageRepository {
    void save(LockerPackage pkg);

    Optional<LockerPackage> findById(String packageId);

    void delete(String packageId);
}
