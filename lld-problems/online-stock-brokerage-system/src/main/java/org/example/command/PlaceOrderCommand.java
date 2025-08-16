package org.example.command;

import org.example.account.Member;
import org.example.entity.StockExchange;
import org.example.entity.StockInventory;
import org.example.order.Order;

import java.util.Objects;

public class PlaceOrderCommand implements Command {
    private final StockExchange exchange;     // Singleton facade
    private final StockInventory inventory;   // for symbol lookup / price access
    private final Member member;
    private final Order order;

    public PlaceOrderCommand(StockExchange exchange,
                             StockInventory inventory,
                             Member member,
                             Order order) {
        this.exchange = Objects.requireNonNull(exchange);
        this.inventory = Objects.requireNonNull(inventory);
        this.member = Objects.requireNonNull(member);
        this.order = Objects.requireNonNull(order);
    }

    @Override
    public void execute() {
        // In a real system: pre-trade checks, margin block, route, etc.
        exchange.placeOrder(inventory, member, order);
    }
}
