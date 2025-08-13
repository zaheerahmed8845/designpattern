package org.example.pricing;

public class FlatRateStrategy implements PricingStrategy {
    @Override
    public double compute(PriceContext ctx) {
        return ctx.rentalDays * ctx.baseDailyRate * ctx.locationMultiplier;
    }
}
