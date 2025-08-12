package org.example.price;

import org.example.entity.PricingContext;
import org.example.price.strategy.GoldPricing;
import org.example.price.strategy.PlatinumPricing;
import org.example.price.strategy.SilverPricing;

public class PricingEngine {
    public double quote(PricingContext c) {
        return switch (c.seatType().toUpperCase()) {
            case "GOLD" -> new GoldPricing().price(c);
            case "PLATINUM" -> new PlatinumPricing().price(c);
            default -> new SilverPricing().price(c);
        };
    }
}
