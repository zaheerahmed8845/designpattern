package org.example;

import org.example.enums.Direction;
import org.example.strategy.SSTFStrategy;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = ElevatorSystem.getInstance(15, 3, new SSTFStrategy());

        User user1 = new User(1);
        User user2 = new User(2);

        user1.requestElevator(4, Direction.UP);
        user2.requestElevator(10, Direction.DOWN);

        system.monitor();
    }
}