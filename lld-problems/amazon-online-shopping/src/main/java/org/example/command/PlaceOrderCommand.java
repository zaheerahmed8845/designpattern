package org.example.command;

import org.example.entity.Order;

public class PlaceOrderCommand implements Command {
    private final Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public boolean execute() {
        return true; /* status handled via Order itself */
    }

    @Override
    public String name() {
        return "placeOrder()";
    }
}
