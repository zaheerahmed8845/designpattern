package org.example.entity;

import org.example.entity.parkingspot.ParkingSpot;
import org.example.entity.parkingspot.ParkingSpotObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard implements ParkingSpotObserver {
    public int id;
    Map<String, List<ParkingSpot>> parkingSpots = new HashMap<>();

    public void addParkingSpot(String spotType, List<ParkingSpot> spots) {
        parkingSpots.put(spotType, spots);
        for (ParkingSpot spot : spots) {
            spot.addObserver(this);
        }
    }

    public void showFreeSlot() {
        for (String type : parkingSpots.keySet()) {
            long count = parkingSpots.get(type).stream().filter(s -> s.isFree).count();
            System.out.println("Available " + type + " spots: " + count);
        }
    }

    @Override
    public void onSpotStatusChange() {
        showFreeSlot();
    }
}
