package org.example.pricing;

public class DynamicPricingStrategy implements PricingStrategy {
    @Override
    public double compute(PriceContext ctx) {
        double base = ctx.rentalDays * ctx.baseDailyRate;
        double demandFactor = ctx.peakSeason ? 1.25 : 1.0;
        double milesFactor = 1.0 + Math.min(0.3, ctx.estimatedMiles / 1000.0);
        return base * ctx.locationMultiplier * demandFactor * milesFactor;
    }
}
