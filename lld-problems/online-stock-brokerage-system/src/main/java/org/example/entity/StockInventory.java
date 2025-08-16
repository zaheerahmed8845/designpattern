package org.example.entity;

import org.example.observer.PriceObserver;
import org.example.search.Search;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

public class StockInventory implements Search, PriceSubject {
    private final String inventoryName;
    private Instant lastUpdated = Instant.now();

    private final Map<String, Stock> bySymbol = new HashMap<>();
    private final Set<PriceObserver> observers = new HashSet<>();

    public StockInventory(String inventoryName) {
        this.inventoryName = Objects.requireNonNull(inventoryName);
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void addStock(Stock stock) {
        bySymbol.put(stock.getSymbol(), stock);
        lastUpdated = Instant.now();
    }

    public void updatePrice(String symbol, BigDecimal newPrice) {
        Stock s = bySymbol.get(symbol);
        if (s != null) {
            s.setPrice(newPrice);
            lastUpdated = Instant.now();
            notifyPrice(symbol, newPrice);
        }
    }

    @Override
    public Optional<Stock> searchSymbol(String symbol) {
        return Optional.ofNullable(bySymbol.get(symbol));
    }

    // --- Observer implementation ---
    @Override
    public void attach(PriceObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(PriceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyPrice(String symbol, BigDecimal newPrice) {
        for (PriceObserver o : observers) o.onPrice(symbol, newPrice);
    }
}
