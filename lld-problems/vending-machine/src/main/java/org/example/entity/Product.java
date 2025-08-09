package org.example.entity;

import org.example.enums.ProductType;

import java.util.Objects;

public class Product {
    private final String name;
    private final int id;
    private final double price;
    private final ProductType type;

    public Product(String name, int id, double price, ProductType type) {
        if (price < 0) throw new IllegalArgumentException("Price must be >= 0");
        this.name = Objects.requireNonNull(name);
        this.id = id;
        this.price = price;
        this.type = Objects.requireNonNull(type);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", id=" + id +
                ", price=" + price + ", type=" + type + '}';
    }
}
