package org.example.pricing;

public interface PricingStrategy {
    double price(PricingContext c);
}