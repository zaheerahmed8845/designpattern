package org.example;

import org.example.entity.Building;
import org.example.entity.ElevatorCar;
import org.example.enums.Direction;
import org.example.strategy.DispatchStrategy;

// ElevatorSystem class
class ElevatorSystem {
    private static ElevatorSystem instance;
    private final Building building;
    private DispatchStrategy strategy;

    private ElevatorSystem(int floors, int elevators, DispatchStrategy strategy) {
        this.building = new Building(floors, elevators);
        this.strategy = strategy;
    }

    public static ElevatorSystem getInstance(int floors, int elevators, DispatchStrategy strategy) {
        if (instance == null) {
            instance = new ElevatorSystem(floors, elevators, strategy);
        }
        return instance;
    }

    public void setStrategy(DispatchStrategy strategy) {
        this.strategy = strategy;
    }

    public void callElevator(int floor, Direction direction) {
        ElevatorCar car = strategy.selectElevator(building.getCars(), floor, direction);
        if (car != null) {
            car.addRequest(floor);
            System.out.println("Request at floor " + floor + " handled by Elevator " + car.getId());
        }
    }

    public void monitor() {
        for (ElevatorCar car : building.getCars()) {
            System.out.println("Elevator " + car.getId() + " at floor " + car.getCurrentFloor() + " | State: " + car.getState());
        }
    }
}
