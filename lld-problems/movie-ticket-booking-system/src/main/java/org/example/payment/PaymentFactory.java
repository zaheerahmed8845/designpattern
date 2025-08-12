package org.example.payment;

public class PaymentFactory {
    public static Payment of(String method) {
        return switch (method.toUpperCase()) {
            case "CARD" -> new CreditCard();
            case "CASH" -> new Cash();
            default -> new CreditCard();
        };
    }
}