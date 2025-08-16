package org.example.strategy;

import org.example.payment.Payment;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount, Payment payment) {
        System.out.println("Accepting cash $" + amount + " for " + payment.paymentId);
        return true;
    }
}