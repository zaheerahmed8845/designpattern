package org.example.entity.parkingfee;

class FlatRateStrategy implements ParkingFeeStrategy {
    private final double flatRate;

    public FlatRateStrategy(double rate) {
        this.flatRate = rate;
    }

    public double calculateFee(double hours) {
        return flatRate;
    }
}
