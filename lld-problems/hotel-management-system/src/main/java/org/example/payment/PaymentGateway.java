package org.example.payment;

public interface PaymentGateway {
    boolean charge(String sourceToken, double amount);
}