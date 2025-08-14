package org.example.search;

import org.example.composite.RoomComponent;
import org.example.composite.RoomGroup;
import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.time.LocalDate;
import java.util.List;

public class Catalog implements Search {
    private static volatile Catalog INSTANCE;
    private final RoomGroup root = new RoomGroup();

    private Catalog() {
    }

    public static Catalog getInstance() {
        if (INSTANCE == null) {
            synchronized (Catalog.class) {
                if (INSTANCE == null) INSTANCE = new Catalog();
            }
        }
        return INSTANCE;
    }

    public RoomComponent getRoot() {
        return root;
    }

    @Override
    public List<Room> searchRoom(RoomStyle style, LocalDate startDate, int durationDays) {
        return root.findAvailable(style);
    }
}
