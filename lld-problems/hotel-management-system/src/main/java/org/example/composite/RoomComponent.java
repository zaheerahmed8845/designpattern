package org.example.composite;

import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.util.List;

public interface RoomComponent {
    void add(RoomComponent c);

    void remove(RoomComponent c);

    List<Room> findAvailable(RoomStyle style);
}
