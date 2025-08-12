package org.example.price.strategy;

import org.example.entity.PricingContext;

public class SilverPricing {
    public double price(PricingContext c) {
        return c.basePrice();
    }
}
