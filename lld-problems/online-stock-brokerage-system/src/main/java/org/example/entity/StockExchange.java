package org.example.entity;

import org.example.account.Member;
import org.example.enums.OrderStatus;
import org.example.enums.TradeSide;
import org.example.order.Order;

import java.math.BigDecimal;
import java.util.Objects;

public class StockExchange {
    private static final StockExchange INSTANCE = new StockExchange();

    private StockExchange() {
    }

    public static StockExchange getInstance() {
        return INSTANCE;
    }

    /**
     * Very simplified execution flow:
     * - Validates symbol exists
     * - Marks order FILLED (no partials here for brevity)
     * - Updates member position
     * - Prints execution details
     */
    public void placeOrder(StockInventory inventory, Member member, Order order) {
        Objects.requireNonNull(inventory);
        Objects.requireNonNull(member);
        Objects.requireNonNull(order);

        inventory.searchSymbol(order.getSymbol())
                .orElseThrow(() -> new IllegalArgumentException("Unknown symbol: " + order.getSymbol()));

        order.validate();

        int qty = order.getTotalQuantity();
        if (qty <= 0) throw new IllegalStateException("Order has no quantity");

        // Execution price heuristic for demo:
        BigDecimal px;
        switch (order.orderType()) {
            case MARKET:
            case STOP_LOSS:
                px = inventory.searchSymbol(order.getSymbol()).get().getPrice();
                break;
            case LIMIT:
            case STOP_LIMIT:
                px = order.getLimitPrice();
                break;
            default:
                throw new IllegalStateException("Unsupported type");
        }

        // Update member positions (very simplified; no funds/margin here)
        StockPosition pos = member.getOrCreatePosition(order.getSymbol());
        if (order.getSide() == TradeSide.BUY) {
            pos.applyBuy(qty, px);
        } else {
            pos.applySell(qty);
        }

        order.setStatus(OrderStatus.FILLED);
        member.addActiveOrder(order.getClientOrderId(), order);

        System.out.println("[Exchange] Executed " + order.orderType()
                + " " + order.getSide()
                + " " + qty + " " + order.getSymbol()
                + " @ " + px + " (TIF=" + order.getTif() + ")");
    }
}
