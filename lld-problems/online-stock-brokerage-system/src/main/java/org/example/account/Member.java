package org.example.account;

import org.example.entity.Address;
import org.example.entity.Stock;
import org.example.entity.StockPosition;
import org.example.enums.AccountStatus;
import org.example.enums.TimeEnforcementType;
import org.example.observer.Watchlist;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Member extends Account {
    private BigDecimal availableFundsForTrading = BigDecimal.ZERO;
    private final LocalDate membershipDate;

    // Positions per symbol
    private final Map<String, StockPosition> stockPositions = new HashMap<>();

    // Active orders (placeholder Object until Order classes are added in next step)
    private final Map<String, Object> activeOrders = new HashMap<>();

    // Watchlists this member owns/subscribes to
    private final List<Watchlist> watchlists = new ArrayList<>();

    // --- scratch fields to model the “selection” interaction from your diagram ---
    private Stock selectedStock;
    private String selectedOrderSide; // "BUY" or "SELL" (simplified)
    private int selectedQty;
    private TimeEnforcementType selectedTif = TimeEnforcementType.GTC;

    public Member(String id,
                  String password,
                  Address address,
                  String email,
                  String phone,
                  LocalDate membershipDate) {
        super(id, password, AccountStatus.ACTIVE, address, email, phone);
        this.membershipDate = membershipDate != null ? membershipDate : LocalDate.now();
    }

    // --- funds ---
    public void deposit(BigDecimal amount) {
        if (amount.signum() > 0) {
            availableFundsForTrading = availableFundsForTrading.add(amount);
        }
    }

    public boolean withdraw(BigDecimal amount) {
        if (amount.signum() <= 0) return false;
        if (availableFundsForTrading.compareTo(amount) < 0) return false;
        availableFundsForTrading = availableFundsForTrading.subtract(amount);
        return true;
    }

    public BigDecimal getAvailableFundsForTrading() {
        return availableFundsForTrading;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    // --- watchlists ---
    public void addWatchlist(Watchlist w) {
        if (w != null) watchlists.add(w);
    }

    public List<Watchlist> getWatchlists() {
        return Collections.unmodifiableList(watchlists);
    }

    // --- selections (match the diagram’s methods semantically) ---
    public void selectStock(Stock stock) {
        this.selectedStock = stock;
    }

    public void selectOrderType(String side) {
        this.selectedOrderSide = side;
    } // simplification

    public void selectStockQty(int qty) {
        this.selectedQty = Math.max(0, qty);
    }

    public void selectTimeEnforcement(TimeEnforcementType tif) {
        this.selectedTif = tif;
    }

    // --- positions helpers ---
    public StockPosition getOrCreatePosition(String symbol) {
        return stockPositions.computeIfAbsent(symbol, s -> new StockPosition(s, 0, BigDecimal.ZERO));
    }

    public Map<String, StockPosition> getStockPositions() {
        return Collections.unmodifiableMap(stockPositions);
    }

    // --- active orders (placeholder until we add Order classes) ---
    public Map<String, Object> getActiveOrders() {
        return Collections.unmodifiableMap(activeOrders);
    }

    public void addActiveOrder(String clientOrderId, Object order) {
        activeOrders.put(clientOrderId, order);
    }

    public void removeActiveOrder(String clientOrderId) {
        activeOrders.remove(clientOrderId);
    }
}
