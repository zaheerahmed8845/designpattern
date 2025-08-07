package org.example.entity.parkingfee;

public class HourlyRateStrategy implements ParkingFeeStrategy {
    private final double hourlyRate;

    public HourlyRateStrategy(double rate) {
        this.hourlyRate = rate;
    }

    public double calculateFee(double hours) {
        return hourlyRate * hours;
    }
}
