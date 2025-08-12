package org.example.pricing;

class GoldPricing implements PricingStrategy {
    public double price(PricingContext c) {
        return c.basePrice() * 1.20;
    }
}