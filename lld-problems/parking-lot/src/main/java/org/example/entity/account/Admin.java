package org.example.entity.account;

import org.example.entity.DisplayBoard;
import org.example.entity.Entrance;
import org.example.entity.Exit;
import org.example.entity.parkingspot.ParkingSpot;

public class Admin extends Account {
    public boolean resetPassword() {
        // reset logic
        return true;
    }

    public boolean addParkingSpot(String floorName, ParkingSpot spot) {
        return true;
    }

    public boolean addDisplayBoard(String floorName, DisplayBoard board) {
        return true;
    }

    public boolean addEntrance(Entrance entrance) {
        return true;
    }

    public boolean addExit(Exit exit) {
        return true;
    }
}
