package org.example.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Stock {
    private final String symbol;
    private BigDecimal price;

    public Stock(String symbol, BigDecimal price) {
        this.symbol = Objects.requireNonNull(symbol);
        this.price = Objects.requireNonNull(price);
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = Objects.requireNonNull(price);
    }

    @Override
    public String toString() {
        return symbol + "@" + price;
    }
}