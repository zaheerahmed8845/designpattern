package org.example.pricing;

class SilverPricing implements PricingStrategy {
    public double price(PricingContext c) {
        return c.basePrice();
    }
}