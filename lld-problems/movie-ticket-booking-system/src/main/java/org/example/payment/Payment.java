package org.example.payment;

public abstract class Payment {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double a) {
        amount = a;
    }

    public abstract boolean makePayment();
}