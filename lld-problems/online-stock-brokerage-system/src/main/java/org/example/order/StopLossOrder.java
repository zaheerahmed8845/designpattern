package org.example.order;

import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

import java.math.BigDecimal;

public class StopLossOrder extends Order {

    public StopLossOrder(String clientOrderId,
                         String memberId,
                         String symbol,
                         TradeSide side,
                         TimeEnforcementType tif,
                         BigDecimal stopPrice) {
        super(clientOrderId, memberId, symbol, side, tif);
        this.stopPrice = stopPrice;
    }

    @Override
    public OrderType orderType() {
        return OrderType.STOP_LOSS;
    }

    @Override
    public void validate() {
        super.validate();
        if (stopPrice == null) throw new IllegalStateException("Stop price required for StopLossOrder");
    }
}
