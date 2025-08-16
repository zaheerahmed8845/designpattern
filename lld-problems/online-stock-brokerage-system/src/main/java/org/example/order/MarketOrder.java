package org.example.order;

import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

public class MarketOrder extends Order {

    public MarketOrder(String clientOrderId,
                       String memberId,
                       String symbol,
                       TradeSide side,
                       TimeEnforcementType tif) {
        super(clientOrderId, memberId, symbol, side, tif);
    }

    @Override
    public OrderType orderType() {
        return OrderType.MARKET;
    }

    @Override
    public void validate() {
        super.validate();
        // For market order, all parts should have null limitPrice
        boolean ok = getParts().stream().allMatch(p -> p.getLimitPrice() == null);
        if (!ok) throw new IllegalStateException("Market order parts must not specify limit price");
    }
}
