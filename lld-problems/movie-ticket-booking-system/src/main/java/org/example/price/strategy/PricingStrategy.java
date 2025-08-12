package org.example.price.strategy;

import org.example.entity.PricingContext;

public interface PricingStrategy {
    double price(PricingContext c);
}
