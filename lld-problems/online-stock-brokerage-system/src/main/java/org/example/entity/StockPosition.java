package org.example.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class StockPosition {
    private final String symbol;
    private int quantity;
    private BigDecimal avgPrice = BigDecimal.ZERO;

    public StockPosition(String symbol, int quantity, BigDecimal avgPrice) {
        this.symbol = Objects.requireNonNull(symbol);
        this.quantity = quantity;
        this.avgPrice = Objects.requireNonNull(avgPrice);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void applyBuy(int qty, BigDecimal price) {
        // Weighted average price update
        BigDecimal totalCost = avgPrice.multiply(BigDecimal.valueOf(quantity))
                .add(price.multiply(BigDecimal.valueOf(qty)));
        quantity += qty;
        if (quantity > 0) {
            avgPrice = totalCost.divide(BigDecimal.valueOf(quantity), avgPrice.scale(), BigDecimal.ROUND_HALF_UP);
        }
    }

    public void applySell(int qty) {
        quantity -= qty;
        if (quantity < 0) quantity = 0; // guard; real system would track lots
    }
}
