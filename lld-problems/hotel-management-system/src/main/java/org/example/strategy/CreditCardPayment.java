package org.example.strategy;

import org.example.payment.PaymentGateway;

public class CreditCardPayment extends AbstractPaymentProcessor {
    private final String tokenOrCardRef;
    private final PaymentGateway gateway;

    public CreditCardPayment(String tokenOrCardRef, PaymentGateway gateway) {
        this.tokenOrCardRef = tokenOrCardRef;
        this.gateway = gateway;
    }

    @Override
    protected boolean doCharge(double amount) {
        return gateway.charge(tokenOrCardRef, amount);
    }
}
