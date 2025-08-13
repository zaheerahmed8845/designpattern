package org.example.decorator;

import org.example.pricing.PriceContext;

public class FuelFineDecorator extends PriceDecorator {
    private final double perGallonFine;
    private final double gallonsMissing;

    public FuelFineDecorator(PriceComponent inner, double perGallonFine, double gallonsMissing) {
        super(inner);
        this.perGallonFine = perGallonFine;
        this.gallonsMissing = gallonsMissing;
    }

    @Override
    public double quote(PriceContext ctx) {
        return inner.quote(ctx) + perGallonFine * Math.max(0.0, gallonsMissing);
    }
}
