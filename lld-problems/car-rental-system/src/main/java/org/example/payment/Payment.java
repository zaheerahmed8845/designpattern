package org.example.payment;

import org.example.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {
    private double amount;
    private PaymentStatus status;
    private LocalDateTime timestamp;

    public Payment(double amount) {
        this.amount = amount;
        this.status = PaymentStatus.Pending;
        this.timestamp = LocalDateTime.now();
    }

    public abstract boolean makePayment();

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
