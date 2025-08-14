package org.example.proxy;

import org.example.product.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Proxy with simple cache for frequently accessed products/reviews.
 */
public class CachedProductRepositoryProxy implements ProductRepository {
    private final ProductRepository backend;
    private final Map<String, Product> cache = new ConcurrentHashMap<>();

    public CachedProductRepositoryProxy(ProductRepository backend) {
        this.backend = backend;
    }

    @Override
    public Product getById(String id) {
        return cache.computeIfAbsent(id, backend::getById);
    }

    @Override
    public void save(Product p) {
        backend.save(p);
        cache.put(p.getProductID(), p);
    }
}
