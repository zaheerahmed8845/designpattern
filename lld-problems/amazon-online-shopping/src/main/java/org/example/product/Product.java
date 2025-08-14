package org.example.product;

import org.example.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productID;
    private String name;
    private String description;
    private List<byte[]> image = new ArrayList<>();
    private double price;
    private int availableCount;
    private ProductCategory category;
    private final List<ProductReview> reviews = new ArrayList<>();
    private Account account;

    public Product() {
    }

    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public boolean updatePrice(double newPrice) {
        if (newPrice < 0) return false;
        this.price = newPrice;
        return true;
    }

    public int updateAvailableCount(int delta) {
        this.availableCount += delta;
        return this.availableCount;
    }

    public List<ProductReview> getReviews() {
        return reviews;
    }

    // getters/setters
    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
