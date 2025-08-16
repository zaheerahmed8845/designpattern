package org.example.command;

import org.example.payment.Payment;
import org.example.strategy.PaymentStrategy;

public class ProcessPaymentCommand implements Command {
    private final Payment payment;
    private final PaymentStrategy strategy;

    public ProcessPaymentCommand(Payment payment, PaymentStrategy strategy) {
        this.payment = payment;
        this.strategy = strategy;
    }

    @Override
    public void execute() {
        payment.makePayment(strategy);
    }
}
