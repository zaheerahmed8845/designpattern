package org.example.payment;

public class PaymentGatewayProxy implements PaymentGateway {
    private final PaymentGateway target;
    private final String apiKey; // auth/rate limit could be here

    public PaymentGatewayProxy(PaymentGateway target, String apiKey) {
        this.target = target;
        this.apiKey = apiKey;
    }

    @Override
    public boolean charge(String sourceToken, double amount) {
        // security checks / caching / rate-limiting
        if (apiKey == null || apiKey.isBlank()) return false;
        return target.charge(sourceToken, amount);
    }
}
