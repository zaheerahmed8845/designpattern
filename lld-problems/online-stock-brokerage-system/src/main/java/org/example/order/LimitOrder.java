package org.example.order;

import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

import java.math.BigDecimal;

public class LimitOrder extends Order {

    public LimitOrder(String clientOrderId,
                      String memberId,
                      String symbol,
                      TradeSide side,
                      TimeEnforcementType tif,
                      BigDecimal limitPrice) {
        super(clientOrderId, memberId, symbol, side, tif);
        this.limitPrice = limitPrice;
    }

    @Override
    public OrderType orderType() {
        return OrderType.LIMIT;
    }

    @Override
    public void validate() {
        super.validate();
        if (limitPrice == null) throw new IllegalStateException("Limit price is required for LimitOrder");
    }
}
