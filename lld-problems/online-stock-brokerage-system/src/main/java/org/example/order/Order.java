package org.example.order;

import org.example.entity.OrderPart;
import org.example.enums.OrderStatus;
import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

public abstract class Order {
    private final String orderNumber;       // system-generated
    private final String clientOrderId;     // idempotency key
    private final String memberId;
    private final String symbol;
    private final TradeSide side;
    private final TimeEnforcementType tif;
    private OrderStatus status = OrderStatus.OPEN;
    private final Instant createdAt = Instant.now();

    // Composite: parts of an order
    private final List<OrderPart> parts = new ArrayList<>();

    // Optional subtype fields
    protected BigDecimal stopPrice;
    protected BigDecimal limitPrice;

    protected Order(String clientOrderId,
                    String memberId,
                    String symbol,
                    TradeSide side,
                    TimeEnforcementType tif) {
        this.orderNumber = UUID.randomUUID().toString();
        this.clientOrderId = Objects.requireNonNull(clientOrderId);
        this.memberId = Objects.requireNonNull(memberId);
        this.symbol = Objects.requireNonNull(symbol);
        this.side = Objects.requireNonNull(side);
        this.tif = Objects.requireNonNull(tif);
    }

    public abstract OrderType orderType();

    // --- Composite helpers ---
    public void addPart(OrderPart part) {
        parts.add(Objects.requireNonNull(part));
    }

    public List<OrderPart> getParts() {
        return Collections.unmodifiableList(parts);
    }

    public int getTotalQuantity() {
        return parts.stream().mapToInt(OrderPart::getQuantity).sum();
    }

    // --- Validation hook ---
    public void validate() {
        if (getTotalQuantity() <= 0) throw new IllegalStateException("Order must have at least one part");
    }

    // --- Getters/Setters ---
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getSymbol() {
        return symbol;
    }

    public TradeSide getSide() {
        return side;
    }

    public TimeEnforcementType getTif() {
        return tif;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getStopPrice() {
        return stopPrice;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
