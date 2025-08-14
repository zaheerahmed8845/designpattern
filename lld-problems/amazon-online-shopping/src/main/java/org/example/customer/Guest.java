package org.example.customer;

import org.example.product.Product;

import java.util.List;

public class Guest extends Customer {
    public boolean registerAccount() {
        return true;
    }

    @Override
    public List<Product> searchProduct(String query) {
        return List.of();
    }
}
