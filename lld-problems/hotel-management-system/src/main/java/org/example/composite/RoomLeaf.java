package org.example.composite;

import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.util.Collections;
import java.util.List;

public class RoomLeaf implements RoomComponent {
    private final Room room;

    public RoomLeaf(Room room) {
        this.room = room;
    }

    @Override
    public void add(RoomComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(RoomComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Room> findAvailable(RoomStyle style) {
        if (room.style == style && room.isRoomAvailable()) return List.of(room);
        return Collections.emptyList();
    }

    public Room getRoom() {
        return room;
    }
}
