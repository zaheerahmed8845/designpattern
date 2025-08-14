package org.example.search;

import org.example.product.Product;
import org.example.product.ProductCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Search {
    private final Map<String, Product> products = new HashMap<>();

    public List<Product> searchProductsByName(String name) {
        if (name == null) return List.of();
        String needle = name.toLowerCase();
        return products.values().stream()
                .filter(p -> p.getName() != null && p.getName().toLowerCase().contains(needle))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByCategory(ProductCategory category) {
        return category == null ? List.of() : category.getProduct();
    }

    public Product getProductDetail(String productId) {
        return products.get(productId);
    }

    public void index(Product p) {
        if (p != null && p.getProductID() != null) products.put(p.getProductID(), p);
    }
}
