package org.example.proxy;

import org.example.product.Product;

public interface ProductRepository {
    Product getById(String id);

    void save(Product p);
}
