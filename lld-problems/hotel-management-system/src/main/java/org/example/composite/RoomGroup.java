package org.example.composite;

import org.example.entity.Room;
import org.example.enums.RoomStyle;

import java.util.ArrayList;
import java.util.List;

public class RoomGroup implements RoomComponent {
    private final List<RoomComponent> children = new ArrayList<>();

    @Override
    public void add(RoomComponent c) {
        if (c != null) children.add(c);
    }

    @Override
    public void remove(RoomComponent c) {
        children.remove(c);
    }

    @Override
    public List<Room> findAvailable(RoomStyle style) {
        List<Room> acc = new ArrayList<>();
        for (var c : children) acc.addAll(c.findAvailable(style));
        return acc;
    }
}
