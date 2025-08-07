package org.example.entity;

import org.example.entity.panel.ElevatorPanel;
import org.example.enums.Direction;
import org.example.enums.ElevatorState;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorCar {
    private final int id;
    private int currentFloor;
    private ElevatorState state;
    private final Door door;
    private final Display display;
    private final ElevatorPanel panel;
    private final Queue<Integer> requestQueue;
    private int load;
    private boolean overload;
    private boolean maintenance;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.state = ElevatorState.IDLE;
        this.door = new Door();
        this.display = new Display();
        this.panel = new ElevatorPanel(16);
        this.requestQueue = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public boolean isInMaintenance() {
        return maintenance;
    }

    public boolean isOverloaded() {
        return overload;
    }

    public void addRequest(int floor) {
        if (!requestQueue.contains(floor)) requestQueue.offer(floor);
    }

    public void move() {
        if (requestQueue.isEmpty() || maintenance || overload) return;
        int dest = requestQueue.poll();
        state = (dest > currentFloor) ? ElevatorState.UP : (dest < currentFloor) ? ElevatorState.DOWN : ElevatorState.IDLE;
        currentFloor = dest;
        state = ElevatorState.IDLE;
        display.update(currentFloor, load, Direction.IDLE, state, maintenance, overload);
    }

    public void emergencyStop() {
        maintenance = true;
        overload = false;
        requestQueue.clear();
        state = ElevatorState.MAINTENANCE;
        door.close();
        display.update(currentFloor, load, Direction.IDLE, state, maintenance, overload);
    }

}
