package org.example.order;

import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

import java.math.BigDecimal;

public class OrderBuilder {
    private OrderType type;
    private String clientOrderId;
    private String memberId;
    private String symbol;
    private TradeSide side;
    private TimeEnforcementType tif = TimeEnforcementType.GTC;
    private int quantity;
    private BigDecimal limitPrice;
    private BigDecimal stopPrice;

    public OrderBuilder type(OrderType type) {
        this.type = type;
        return this;
    }

    public OrderBuilder clientOrderId(String id) {
        this.clientOrderId = id;
        return this;
    }

    public OrderBuilder memberId(String id) {
        this.memberId = id;
        return this;
    }

    public OrderBuilder symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public OrderBuilder side(TradeSide side) {
        this.side = side;
        return this;
    }

    public OrderBuilder tif(TimeEnforcementType tif) {
        this.tif = tif;
        return this;
    }

    public OrderBuilder quantity(int qty) {
        this.quantity = qty;
        return this;
    }

    public OrderBuilder limitPrice(BigDecimal lp) {
        this.limitPrice = lp;
        return this;
    }

    public OrderBuilder stopPrice(BigDecimal sp) {
        this.stopPrice = sp;
        return this;
    }

    public Order build() {
        if (type == null) throw new IllegalStateException("OrderType required");
        return OrderFactory.create(type, clientOrderId, memberId, symbol, side, tif, quantity, limitPrice, stopPrice);
    }
}
