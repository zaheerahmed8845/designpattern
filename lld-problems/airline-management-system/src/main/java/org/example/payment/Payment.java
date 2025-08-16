package org.example.payment;

import org.example.enums.PaymentStatus;
import org.example.strategy.PaymentStrategy;

import java.time.LocalDateTime;

public abstract class Payment {
    public String paymentId = "PAY-" + System.nanoTime();
    public double amount;
    public PaymentStatus status = PaymentStatus.PENDING;
    public LocalDateTime timestamp = LocalDateTime.now();

    // Strategy: delegate the payment process
    public boolean makePayment(PaymentStrategy strategy) {
        boolean ok = strategy.pay(amount, this);
        status = ok ? PaymentStatus.COMPLETED : PaymentStatus.FAILED;
        return ok;
    }
}
