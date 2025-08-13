package org.example.decorator;

import org.example.pricing.PriceContext;

public class DamageFineDecorator extends PriceDecorator {
    private final double damageFine;

    public DamageFineDecorator(PriceComponent inner, double damageFine) {
        super(inner);
        this.damageFine = damageFine;
    }

    @Override
    public double quote(PriceContext ctx) {
        return inner.quote(ctx) + damageFine;
    }
}
