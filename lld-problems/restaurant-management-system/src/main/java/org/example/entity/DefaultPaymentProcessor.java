package org.example.entity;

import org.example.strategy.PaymentStrategy;

public class DefaultPaymentProcessor extends PaymentProcessor {
    @Override
    protected boolean initiateTransaction(Bill bill, PaymentStrategy strategy) {
        return strategy.charge(bill);
    }
}
