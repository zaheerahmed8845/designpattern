package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRentalSystem {
    private String name;
    private final List<CarRentalBranch> branches = new ArrayList<>();

    public CarRentalSystem(String name) {
        this.name = name;
    }

    public void addNewBranch(CarRentalBranch branch) {
        branches.add(branch);
    }

    public List<CarRentalBranch> getBranches() {
        return Collections.unmodifiableList(branches);
    }
}
