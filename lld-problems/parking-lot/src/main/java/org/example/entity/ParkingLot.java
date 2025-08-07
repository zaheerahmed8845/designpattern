package org.example.entity;

import org.example.entity.parkingspot.ParkingSpot;
import org.example.entity.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static volatile ParkingLot instance;
    public int id;
    public String name;
    public Address address;
    public ParkingRate parkingRate;
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

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        Entrance entrance = entrances.values().stream().findFirst().orElse(null);
        if (entrance == null || isFull()) return null;
        ParkingTicket ticket = entrance.getTicket(vehicle);
        tickets.put(vehicle.licenseNo, ticket);
        return ticket;
    }

    public boolean isFull() {
        return spots.values().stream().noneMatch(s -> s.isFree);
    }
}
