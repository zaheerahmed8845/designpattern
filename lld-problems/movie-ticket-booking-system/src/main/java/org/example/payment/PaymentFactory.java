package org.example.payment;

public class PaymentFactory {
    public static Payment of(String method, String ref) {
        return switch (method.toUpperCase()) {
            case "CARD" -> new CardPayment(ref);
            case "UPI" -> new UpiPayment(ref);
            default -> new CashPayment();
        };
    }
}
