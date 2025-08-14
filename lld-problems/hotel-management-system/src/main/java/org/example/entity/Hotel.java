package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public String name;
    private final List<HotelBranch> branches = new ArrayList<>();

    public boolean addLocation(HotelBranch b) {
        return b != null && branches.add(b);
    }

    public List<HotelBranch> getBranches() {
        return branches;
    }
}
