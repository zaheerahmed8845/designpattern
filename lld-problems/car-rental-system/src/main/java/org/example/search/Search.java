package org.example.search;

import org.example.vehicle.Vehicle;

import java.util.List;

public interface Search {
    List<Vehicle> searchByType(String type);

    List<Vehicle> searchByModel(String model);
}
