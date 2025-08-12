package org.example.pricing;

public class PricingEngine {
    public double quote(PricingContext c) {
        return switch (c.seatType().toUpperCase()) {
            case "GOLD" -> new GoldPricing().price(c);
            case "PLATINUM" -> new PlatinumPricing().price(c);
            default -> new SilverPricing().price(c);
        };
    }
}
