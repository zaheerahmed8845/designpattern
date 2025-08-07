package org.example.entity;

import org.example.entity.parkingfee.ParkingFeeStrategy;

public class ParkingRate {
    double hours;
    double rate;

    ParkingFeeStrategy strategy;

    public ParkingRate(ParkingFeeStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double hours) {
        return strategy.calculateFee(hours);
    }
}
