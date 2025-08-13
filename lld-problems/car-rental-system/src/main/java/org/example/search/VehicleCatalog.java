package org.example.search;

import org.example.vehicle.Vehicle;

import java.util.*;

public class VehicleCatalog implements Search {
    private final Map<String, List<Vehicle>> vehicleTypes = new HashMap<>();
    private final Map<String, List<Vehicle>> vehicleModels = new HashMap<>();

    public void index(Vehicle vehicle) {
        vehicleTypes.computeIfAbsent(vehicle.getTypeKey(), k -> new ArrayList<>()).add(vehicle);
        vehicleModels.computeIfAbsent(vehicle.getModel().toLowerCase(), k -> new ArrayList<>()).add(vehicle);
    }

    @Override
    public List<Vehicle> searchByType(String type) {
        return Collections.unmodifiableList(vehicleTypes.getOrDefault(type, Collections.emptyList()));
    }

    @Override
    public List<Vehicle> searchByModel(String model) {
        return Collections.unmodifiableList(vehicleModels.getOrDefault(model.toLowerCase(), Collections.emptyList()));
    }
}
