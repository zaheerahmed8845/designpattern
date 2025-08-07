package org.example.strategy;

import org.example.entity.ElevatorCar;
import org.example.enums.Direction;
import org.example.enums.ElevatorState;

import java.util.List;

// LOOK Strategy
class LOOKStrategy implements DispatchStrategy {
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
        ElevatorCar best = null;
        int bestGap = Integer.MAX_VALUE;
        for (ElevatorCar car : elevators) {
            if (car.getState() == ElevatorState.IDLE || (car.getState() == ElevatorState.UP && floor > car.getCurrentFloor()) ||
                    (car.getState() == ElevatorState.DOWN && floor < car.getCurrentFloor())) {
                int gap = Math.abs(car.getCurrentFloor() - floor);
                if (gap < bestGap) {
                    bestGap = gap;
                    best = car;
                }
            }
        }
        return best;
    }
}
