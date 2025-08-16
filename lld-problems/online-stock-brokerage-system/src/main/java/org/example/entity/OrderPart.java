package org.example.entity;

import java.math.BigDecimal;

public class OrderPart {
    private final int quantity;
    private final BigDecimal limitPrice; // can be null for market parts

    public OrderPart(int quantity, BigDecimal limitPrice) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        this.quantity = quantity;
        this.limitPrice = limitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }
}
