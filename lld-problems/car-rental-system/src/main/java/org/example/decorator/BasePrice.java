package org.example.decorator;

import org.example.pricing.PriceContext;
import org.example.pricing.PricingStrategy;

public class BasePrice implements PriceComponent {
    private final PricingStrategy strategy;

    public BasePrice(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public double quote(PriceContext ctx) {
        return strategy.compute(ctx);
    }
}
