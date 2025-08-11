package org.example.entity.room;

public class RoomFactory {
    public Room create(String type, int id, int capacity) {
        return switch (type.toUpperCase()) {
            case "STANDARD" -> new StandardRoom(id, capacity);
            case "BOARD" -> new BoardRoom(id, capacity);
            case "AUDITORIUM" -> new Auditorium(id, capacity);
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        };
    }
}

