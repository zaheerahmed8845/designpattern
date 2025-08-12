package org.example.price.strategy;

import org.example.entity.PricingContext;

import java.time.LocalTime;

public class PlatinumPricing implements PricingStrategy {
    public double price(PricingContext c) {
        double p = c.basePrice() * 1.50;
        if (c.time().isAfter(LocalTime.of(18, 0))) p *= 1.10;   // evening premium
        if (c.occupancy() > 0.80) p *= 1.05;                   // surge
        return p;
    }
}
