package org.example.builder;

import org.example.composite.MenuItem;

public class MealItem {
    private final MenuItem menuItem;
    private int quantity;

    public MealItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int q) {
        this.quantity = q;
    }

    public double lineTotal() {
        return menuItem.getPrice() * quantity;
    }
}
