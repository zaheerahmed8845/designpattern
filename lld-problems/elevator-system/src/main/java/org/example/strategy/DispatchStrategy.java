package org.example.strategy;

import org.example.entity.ElevatorCar;
import org.example.enums.Direction;

import java.util.List;

public interface DispatchStrategy {

    ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction);
}
