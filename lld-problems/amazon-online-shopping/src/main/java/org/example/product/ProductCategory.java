package org.example.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductCategory {
    private String name;
    private String description;
    private final List<Product> product = new ArrayList<>();

    public ProductCategory() {
    }

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public boolean addProduct(Product p) {
        if (p == null || product.contains(p)) return false;
        product.add(p);
        p.setCategory(this);
        return true;
    }

    public List<Product> getProduct() {
        return Collections.unmodifiableList(product);
    }

    // getters/setters
}
