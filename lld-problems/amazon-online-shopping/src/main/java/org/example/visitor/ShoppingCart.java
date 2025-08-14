package org.example.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private final List<CartItem> items = new ArrayList<>();

    public boolean addItem(CartItem item) {
        if (item == null) return false;
        items.add(item);
        recalc();
        return true;
    }

    public boolean removeItem(CartItem item) {
        boolean ok = items.remove(item);
        if (ok) recalc();
        return ok;
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean checkout() {
        return !items.isEmpty();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void recalc() {
        totalPrice = items.stream().mapToDouble(CartItem::getPrice).sum();
    }
}
