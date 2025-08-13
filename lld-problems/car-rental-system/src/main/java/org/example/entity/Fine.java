package org.example.entity;

public class Fine {
    private double amount;
    private String reason;

    public Fine(double amount, String reason) {
        this.amount = amount;
        this.reason = reason;
    }

    public double calculateFine() {
        return amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }
}
