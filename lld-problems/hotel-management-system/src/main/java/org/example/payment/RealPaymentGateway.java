package org.example.payment;

public class RealPaymentGateway implements PaymentGateway {
    @Override
    public boolean charge(String sourceToken, double amount) { /* call provider */
        return true;
    }
}
