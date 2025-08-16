package org.example.strategy;

import org.example.payment.Payment;

public interface PaymentStrategy {
    boolean pay(double amount, Payment payment);
}
