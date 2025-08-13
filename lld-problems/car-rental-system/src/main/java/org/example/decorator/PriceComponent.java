package org.example.decorator;

import org.example.pricing.PriceContext;

public interface PriceComponent {
    double quote(PriceContext ctx);
}
