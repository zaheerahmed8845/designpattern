package org.example.entity;

import org.example.enums.RoomStatus;
import org.example.enums.RoomStyle;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public String roomNumber;
    public RoomStyle style;
    public RoomStatus status = RoomStatus.Available;
    public double bookingPrice;
    public boolean isSmoking;
    public final List<RoomKey> keys = new ArrayList<>();
    public final List<RoomHousekeeping> housekeepingLog = new ArrayList<>();

    public boolean isRoomAvailable() {
        return status == RoomStatus.Available;
    }

    public boolean checkIn() {
        if (!isRoomAvailable()) return false;
        status = RoomStatus.Occupied;
        return true;
    }

    public boolean checkOut() {
        status = RoomStatus.Available;
        return true;
    }
}
