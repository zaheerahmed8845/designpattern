package org.example.price.strategy;

import org.example.entity.PricingContext;

public class GoldPricing {
    public double price(PricingContext c) {
        return c.basePrice() * 1.20;
    }
}
