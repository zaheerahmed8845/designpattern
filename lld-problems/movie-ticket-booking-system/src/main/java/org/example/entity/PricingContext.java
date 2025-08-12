package org.example.entity;


import java.time.DayOfWeek;
import java.time.LocalTime;

public record PricingContext(String showId, String seatType,
                             DayOfWeek day, LocalTime time,
                             double basePrice, double occupancy) {
}
