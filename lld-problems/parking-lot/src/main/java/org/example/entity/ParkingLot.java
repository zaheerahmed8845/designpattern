package org.example.entity;

import org.example.entity.parkingspot.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static volatile ParkingLot instance;
    public int id;
    public String name;
    public Address address;
    ParkingRate parkingRate;
    public Map<String, Entrance> entrances = new HashMap<>();
    public Map<String, Exit> exits = new HashMap<>();
    public Map<String, ParkingSpot> spots = new HashMap<>();
    public Map<String, ParkingTicket> tickets = new HashMap<>();
    public List<DisplayBoard> displayBoards = new ArrayList<>();

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public ParkingTicket getParkingTicket() {
        return new ParkingTicket();
    }

    public boolean isFull() {
        // Check if all spots are full
        return false;
    }
}
