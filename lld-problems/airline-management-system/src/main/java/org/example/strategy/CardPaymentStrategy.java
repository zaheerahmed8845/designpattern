package org.example.strategy;

import org.example.payment.Payment;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount, Payment payment) {
        // stub gateway call
        System.out.println("Charging credit card $" + amount + " for " + payment.paymentId);
        return true;
    }
}
