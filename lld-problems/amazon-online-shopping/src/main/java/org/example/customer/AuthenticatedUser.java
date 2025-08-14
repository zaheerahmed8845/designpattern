package org.example.customer;

import org.example.entity.Account;
import org.example.entity.Order;
import org.example.product.Product;
import org.example.visitor.CartItem;
import org.example.visitor.ShoppingCart;

import java.util.List;

public class AuthenticatedUser extends Customer {
    private Order order;
    private Account account;

    public boolean placeOrder(Order order) {
        this.order = order;
        return true;
    }

    public boolean addItem(Product product, int quantity) {
        ShoppingCart c = getCart();
        return c.addItem(new CartItem(product, quantity, product.getPrice()));
    }

    public ShoppingCart getShoppingCart() {
        return getCart();
    }

    public boolean initiatePayment() {
        return true;
    }

    @Override
    public List<Product> searchProduct(String query) {
        return List.of();
    }
}
