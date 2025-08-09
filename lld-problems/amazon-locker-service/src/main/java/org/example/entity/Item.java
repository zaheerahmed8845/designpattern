package org.example.entity;

import java.util.Objects;

public class Item {
    private String itemId;
    private int quantity;

    public Item(String itemId, int quantity) {
        this.itemId = Objects.requireNonNull(itemId);
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
