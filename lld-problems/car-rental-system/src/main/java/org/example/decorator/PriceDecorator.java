package org.example.decorator;

public abstract class PriceDecorator implements PriceComponent {
    protected final PriceComponent inner;

    protected PriceDecorator(PriceComponent inner) {
        this.inner = inner;
    }
}
