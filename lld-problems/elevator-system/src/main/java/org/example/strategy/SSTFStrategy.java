package org.example.strategy;

import org.example.entity.ElevatorCar;
import org.example.enums.Direction;

import java.util.List;

public class SSTFStrategy implements DispatchStrategy {

    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
        ElevatorCar best = null;
        int minDist = Integer.MAX_VALUE;
        for (ElevatorCar car : elevators) {
            if (car.isInMaintenance()) continue;
            int dist = Math.abs(car.getCurrentFloor() - floor);
            if (dist < minDist) {
                minDist = dist;
                best = car;
            }
        }
        return best;
    }
}
