package org.example.entity;

import java.util.*;

public class Inventory {
    private final Map<Integer, Rack> racks = new HashMap<>();

    public void addRack(Rack rack) {
        if (racks.containsKey(rack.getRackNumber()))
            throw new IllegalArgumentException("Rack already exists: " + rack.getRackNumber());
        racks.put(rack.getRackNumber(), rack);
    }

    public Rack getRack(int rackNumber) {
        Rack r = racks.get(rackNumber);
        if (r == null) throw new NoSuchElementException("No rack: " + rackNumber);
        return r;
    }

    public Collection<Rack> allRacks() {
        return Collections.unmodifiableCollection(racks.values());
    }
}
