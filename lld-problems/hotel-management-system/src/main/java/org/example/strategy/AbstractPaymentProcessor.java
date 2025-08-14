package org.example.strategy;

import org.example.enums.PaymentStatus;

public abstract class AbstractPaymentProcessor implements PaymentStrategy {
    protected PaymentStatus status = PaymentStatus.Pending;

    @Override
    public final boolean pay(double amount) {
        try {
            preValidate(amount);
            boolean ok = doCharge(amount);
            postRecord(ok, amount);
            status = ok ? PaymentStatus.Completed : PaymentStatus.Failed;
            return ok;
        } catch (Exception ex) {
            status = PaymentStatus.Failed;
            return false;
        }
    }

    protected void preValidate(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount");
    }

    protected abstract boolean doCharge(double amount);

    protected void postRecord(boolean ok, double amount) { /* audit/log */ }

    public PaymentStatus getStatus() {
        return status;
    }
}
