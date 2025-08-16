package org.example.order;

import org.example.entity.OrderPart;
import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;

import java.math.BigDecimal;

public class OrderFactory {

    public static Order create(OrderType type,
                               String clientOrderId,
                               String memberId,
                               String symbol,
                               TradeSide side,
                               TimeEnforcementType tif,
                               int quantity,
                               BigDecimal limitPrice,
                               BigDecimal stopPrice) {

        Order order;
        switch (type) {
            case MARKET:
                order = new MarketOrder(clientOrderId, memberId, symbol, side, tif);
                order.addPart(new OrderPart(quantity, null));
                break;
            case LIMIT:
                order = new LimitOrder(clientOrderId, memberId, symbol, side, tif, limitPrice);
                order.addPart(new OrderPart(quantity, limitPrice));
                break;
            case STOP_LOSS:
                order = new StopLossOrder(clientOrderId, memberId, symbol, side, tif, stopPrice);
                order.addPart(new OrderPart(quantity, null));
                break;
            case STOP_LIMIT:
                order = new StopLimitOrder(clientOrderId, memberId, symbol, side, tif, stopPrice, limitPrice);
                order.addPart(new OrderPart(quantity, limitPrice));
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }

        order.validate();
        return order;
    }

    private OrderFactory() {
    }
}
