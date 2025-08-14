package org.example.search;

import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.time.LocalDate;
import java.util.List;

public interface Search {
    List<Room> searchRoom(RoomStyle style, LocalDate startDate, int durationDays);
}
