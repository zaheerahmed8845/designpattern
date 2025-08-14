package org.example.command;

import org.example.product.Product;
import org.example.visitor.CartItem;
import org.example.visitor.ShoppingCart;

public class AddProductToCartCommand implements Command {
    private final ShoppingCart cart;
    private final Product product;
    private final int qty;

    public AddProductToCartCommand(ShoppingCart cart, Product product, int qty) {
        this.cart = cart;
        this.product = product;
        this.qty = qty;
    }

    @Override
    public boolean execute() {
        return cart.addItem(new CartItem(product, qty, product.getPrice()));
    }

    @Override
    public String name() {
        return "addProduct(" + product.getName() + " x" + qty + ")";
    }
}
