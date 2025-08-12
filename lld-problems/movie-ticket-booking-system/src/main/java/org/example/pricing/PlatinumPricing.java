package org.example.pricing;

import java.time.LocalTime;

class PlatinumPricing implements PricingStrategy {
    public double price(PricingContext c) {
        double p = c.basePrice() * 1.50;
        if (c.time().isAfter(LocalTime.of(18, 0))) p *= 1.10;
        if (c.occupancy() > 0.80) p *= 1.05;
        return p;
    }
}
