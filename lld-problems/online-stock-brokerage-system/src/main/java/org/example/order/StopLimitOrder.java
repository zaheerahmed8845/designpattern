package org.example.order;

import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

import java.math.BigDecimal;

public class StopLimitOrder extends Order {

    public StopLimitOrder(String clientOrderId,
                          String memberId,
                          String symbol,
                          TradeSide side,
                          TimeEnforcementType tif,
                          BigDecimal stopPrice,
                          BigDecimal limitPrice) {
        super(clientOrderId, memberId, symbol, side, tif);
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
    }

    @Override
    public OrderType orderType() {
        return OrderType.STOP_LIMIT;
    }

    @Override
    public void validate() {
        super.validate();
        if (stopPrice == null || limitPrice == null) {
            throw new IllegalStateException("StopLimit requires both stop and limit prices");
        }
    }
}
