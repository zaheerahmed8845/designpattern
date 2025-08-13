package org.example.pricing;

public interface PricingStrategy {
    double compute(PriceContext ctx);
}
