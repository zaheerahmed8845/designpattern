package org.example.customer;

import org.example.product.Product;
import org.example.visitor.ShoppingCart;

import java.util.List;

public abstract class Customer {
    protected ShoppingCart cart;

    public abstract List<Product> searchProduct(String query);

    public ShoppingCart getCart() {
        if (cart == null) cart = new ShoppingCart();
        return cart;
    }
}
