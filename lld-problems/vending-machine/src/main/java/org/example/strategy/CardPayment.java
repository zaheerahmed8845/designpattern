package org.example.strategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean authorize(double amount) {
        // Mock: pretend authorization succeeds.
        return true;
    }

    @Override
    public boolean capture(double amount) {
        // Mock: capture succeeds.
        return true;
    }

    @Override
    public void refund(double amount) {
        // Mock: no-op
    }

    @Override
    public String name() {
        return "CARD";
    }
}