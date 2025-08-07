package org.example.entity;

import org.example.enums.Direction;
import org.example.enums.ElevatorState;

public class Display {
    private int floor;
    private int load;
    private Direction direction;
    private ElevatorState state;
    private boolean maintenance;
    private boolean overload;

    public void update(int floor, int load, Direction direction, ElevatorState state, boolean maintenance, boolean overload) {
        this.floor = floor;
        this.load = load;
        this.direction = direction;
        this.state = state;
        this.maintenance = maintenance;
        this.overload = overload;
        showElevatorDisplay();
    }

    public void showElevatorDisplay() {
        System.out.println("[Display] Floor: " + floor + ", Load: " + load + "kg, Direction: " + direction + ", State: " + state + ", Maintenance: " + maintenance + ", Overload: " + overload);
    }
}
