package org.example.entity;

public class Rack {
    private final int rackNumber;
    private final Product product;   // one product type per rack
    private int quantity;

    public Rack(int rackNumber, Product product, int quantity) {
        if (rackNumber < 0) throw new IllegalArgumentException("rackNumber must be >= 0");
        if (quantity < 0) throw new IllegalArgumentException("quantity must be >= 0");
        this.rackNumber = rackNumber;
        this.product = product;
        this.quantity = quantity;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    public void loadProduct(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("qty must be > 0");
        this.quantity += qty;
    }

    public Product peekProduct() {
        return product;
    }

    public void dispenseOne() {
        if (quantity <= 0) throw new IllegalStateException("Rack " + rackNumber + " is empty");
        quantity--;
    }

    @Override
    public String toString() {
        return "Rack{" + "rackNumber=" + rackNumber +
                ", product=" + product.getName() +
                ", qty=" + quantity + '}';
    }
}
