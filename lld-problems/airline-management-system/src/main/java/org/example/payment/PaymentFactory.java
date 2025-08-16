package org.example.payment;

import org.example.enums.PaymentMethod;

public class PaymentFactory {
    public static Payment create(PaymentMethod method, double amount, String holderOrNull, String cardNumberOrNull) {
        switch (method) {
            case CREDIT_CARD:
                return new CreditCard(holderOrNull, cardNumberOrNull, amount);
            case CASH:
                return new Cash(amount);
            default:
                throw new IllegalArgumentException("Unknown payment method: " + method);
        }
    }
}
