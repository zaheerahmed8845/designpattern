package org.example.decorator;

import org.example.pricing.PriceContext;

public class PeakSeasonDecorator extends PriceDecorator {
    private final double peakMultiplier;

    public PeakSeasonDecorator(PriceComponent inner, double peakMultiplier) {
        super(inner);
        this.peakMultiplier = peakMultiplier;
    }

    @Override
    public double quote(PriceContext ctx) {
        double p = inner.quote(ctx);
        return ctx.peakSeason ? p * peakMultiplier : p;
    }
}
