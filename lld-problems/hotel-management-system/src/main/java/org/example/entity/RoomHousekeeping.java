package org.example.entity;

import org.example.person.HouseKeeper;

import java.time.LocalDateTime;

public class RoomHousekeeping {
    public String description;
    public LocalDateTime startDateTime;
    public int duration;
    public HouseKeeper housekeeper;

    public boolean addHouseKeeping() {
        return true;
    }
}
