package org.example.observer;

import org.example.entity.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Watchlist implements PriceObserver {
    private final String name;
    private final List<Stock> stocks = new ArrayList<>();

    public Watchlist(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void addStock(Stock stock) {
        stocks.add(Objects.requireNonNull(stock));
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public List<Stock> getStocks() {
        return Collections.unmodifiableList(stocks);
    }

    // Receive real-time price updates
    @Override
    public void onPrice(String symbol, BigDecimal newPrice) {
        // In a UI app you’d push this to the client; here we just log.
        System.out.println("[Watchlist:" + name + "] " + symbol + " -> " + newPrice);
    }
}
