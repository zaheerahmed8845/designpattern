package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelBranch {
    public String name;
    public Address address;
    private final List<Room> rooms = new ArrayList<>();

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }
}
