package org.example.repository;

import org.example.entity.LockerPackage;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPackageRepository implements PackageRepository {
    private final Map<String, LockerPackage> packages = new ConcurrentHashMap<>();

    @Override
    public void save(LockerPackage pkg) {
        packages.put(pkg.getPackageId(), pkg);
    }

    @Override
    public Optional<LockerPackage> findById(String packageId) {
        return Optional.ofNullable(packages.get(packageId));
    }

    @Override
    public void delete(String packageId) {
        packages.remove(packageId);
    }
}
