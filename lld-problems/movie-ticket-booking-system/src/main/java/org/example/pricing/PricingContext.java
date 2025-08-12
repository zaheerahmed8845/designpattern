package org.example.pricing;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record PricingContext(String seatType, DayOfWeek day, LocalTime time, double basePrice, double occupancy) {
}

