package org.example;

import org.example.enums.Direction;
import org.example.strategy.FCFSStrategy;

public class User {
    private final int id;

    public User(int id) {
        this.id = id;
    }

    public void requestElevator(int floor, Direction direction) {
        ElevatorSystem.getInstance(15, 3, new FCFSStrategy()).callElevator(floor, direction);
    }
}
