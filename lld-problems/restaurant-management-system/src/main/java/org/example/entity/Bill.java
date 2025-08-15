package org.example.entity;

import org.example.enums.PaymentStatus;

public class Bill {
    private final int billId;
    private final Order order;
    private double amount;
    private double tax;
    private double tip;
    private PaymentStatus status = PaymentStatus.UNPAID;

    public Bill(Order order) {
        this(0, order);
    }

    public Bill(int billId, Order order) {
        this.billId = billId;
        this.order = order;
        this.amount = order.total();
        this.tax = amount * 0.1; // placeholder
    }

    public double totalDue() {
        return amount + tax + tip;
    }

    public void addTip(double tip) {
        this.tip = tip;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }
}
