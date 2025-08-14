package org.example.payment;

import org.example.enums.PaymentStatus;

/**
 * Strategy base: concrete payments implement makePayment()
 */
public abstract class Payment {
    protected double amount;
    protected PaymentStatus status = PaymentStatus.Pending;

    public abstract PaymentStatus makePayment();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
