package org.example.strategy;

public interface PaymentStrategy {
    /**
     * Reserve/verify funds before dispensing.
     */
    boolean authorize(double amount);

    /**
     * Finalize the charge.
     */
    boolean capture(double amount);

    /**
     * Return funds (full or partial).
     */
    void refund(double amount);

    String name();
}
