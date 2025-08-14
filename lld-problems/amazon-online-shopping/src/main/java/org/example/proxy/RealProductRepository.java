package org.example.proxy;

import org.example.product.Product;

import java.util.HashMap;
import java.util.Map;

public class RealProductRepository implements ProductRepository {
    private final Map<String, Product> db = new HashMap<>();

    @Override
    public Product getById(String id) {
        return db.get(id);
    }

    @Override
    public void save(Product p) {
        db.put(p.getProductID(), p);
    }
}
