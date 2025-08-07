package org.example.entity;

import org.example.entity.parkingspot.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    public int id;
    Map<String, List<ParkingSpot>> parkingSpot = new HashMap<>();

    public void addParkingSpot(String spotType, List<ParkingSpot> spots) {
        parkingSpot.put(spotType, spots);
    }

    public void showFreeSlot() {
        // Display logic
    }
}
