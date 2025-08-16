package org.example.entity;

import org.example.observer.PriceObserver;

import java.math.BigDecimal;

public interface PriceSubject {
    void attach(PriceObserver observer);

    void detach(PriceObserver observer);

    void notifyPrice(String symbol, BigDecimal newPrice);
}
