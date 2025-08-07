package org.example.strategy;

import org.example.entity.ElevatorCar;
import org.example.enums.Direction;
import org.example.enums.ElevatorState;

import java.util.List;

// SCAN Strategy
class SCANStrategy implements DispatchStrategy {
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
        for (ElevatorCar car : elevators) {
            if (car.getState() == ElevatorState.IDLE || (car.getState() == ElevatorState.UP && direction == Direction.UP)) {
                return car;
            }
        }
        return elevators.get(0);
    }
}
