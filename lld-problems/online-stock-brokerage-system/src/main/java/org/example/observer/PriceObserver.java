package org.example.observer;

import java.math.BigDecimal;

public interface PriceObserver {
    void onPrice(String symbol, BigDecimal newPrice);
}
