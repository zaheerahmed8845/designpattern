package org.example.strategy;

import org.example.entity.ElevatorCar;
import org.example.enums.Direction;
import org.example.enums.ElevatorState;

import java.util.List;

// FCFS Strategy
public class FCFSStrategy implements DispatchStrategy {
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
        for (ElevatorCar car : elevators) {
            if (car.getState() == ElevatorState.IDLE) return car;
        }
        return elevators.get(0); // fallback
    }
}
