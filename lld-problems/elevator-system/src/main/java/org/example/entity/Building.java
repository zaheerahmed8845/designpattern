package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Building {

    List<Floor> floors;
    List<ElevatorCar> cars;

    public Building(int numFloors, int numElevators) {
        floors = new ArrayList<>();
        cars = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) floors.add(new Floor(i));
        for (int i = 0; i < numElevators; i++) cars.add(new ElevatorCar(i));
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<ElevatorCar> getCars() {
        return cars;
    }

}
