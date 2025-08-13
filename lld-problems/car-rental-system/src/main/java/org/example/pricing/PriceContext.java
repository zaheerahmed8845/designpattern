package org.example.pricing;

import java.time.LocalDateTime;

public class PriceContext {
    public final int rentalDays;
    public final double baseDailyRate;
    public final double locationMultiplier;
    public final boolean peakSeason;
    public final double estimatedMiles;
    public final String vehicleTypeKey;
    public final LocalDateTime start;
    public final LocalDateTime end;

    public PriceContext(int rentalDays, double baseDailyRate, double locationMultiplier,
                        boolean peakSeason, double estimatedMiles, String vehicleTypeKey,
                        LocalDateTime start, LocalDateTime end) {
        this.rentalDays = rentalDays;
        this.baseDailyRate = baseDailyRate;
        this.locationMultiplier = locationMultiplier;
        this.peakSeason = peakSeason;
        this.estimatedMiles = estimatedMiles;
        this.vehicleTypeKey = vehicleTypeKey;
        this.start = start;
        this.end = end;
    }
}
