package org.example.visitor;

import org.example.product.Product;

public class CartItem {
    private Product product;
    private int quantity;
    private double price; // unit price snapshot

    public CartItem(Product product, int quantity, double unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.price = unitPrice;
    }

    public boolean updateQuantity(int quantity) {
        if (quantity <= 0) return false;
        this.quantity = quantity;
        return true;
    }

    public double getPrice() {
        return price * quantity;
    }

    // getters
    public Product getProduct() {
        return product;
    }
}
