package org.example.person;

import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class HouseKeeper extends Person {
    public boolean assignTo(Room room) {
        return true;
    }

    @Override
    public List<Room> searchRoom(RoomStyle s, LocalDate d, int dur) {
        return Collections.emptyList();
    }
}
