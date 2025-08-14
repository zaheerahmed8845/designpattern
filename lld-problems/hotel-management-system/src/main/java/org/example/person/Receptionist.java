package org.example.person;

import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Receptionist extends Person {
    public boolean createBooking() {
        return true;
    }

    @Override
    public List<Room> searchRoom(RoomStyle s, LocalDate d, int dur) {
        return Collections.emptyList();
    }
}
