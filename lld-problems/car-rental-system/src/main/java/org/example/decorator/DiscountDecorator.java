package org.example.decorator;

import org.example.pricing.PriceContext;

public class DiscountDecorator extends PriceDecorator {
    private final double percent;

    public DiscountDecorator(PriceComponent inner, double percent) {
        super(inner);
        this.percent = percent;
    }

    @Override
    public double quote(PriceContext ctx) {
        return inner.quote(ctx) * (1.0 - percent);
    }
}
