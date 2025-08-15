package org.example.entity;

import org.example.enums.PaymentStatus;
import org.example.strategy.PaymentStrategy;

public abstract class PaymentProcessor {

    // Template Method: defines the steps
    public final boolean process(Bill bill, PaymentStrategy strategy) {
        prepareBill(bill);
        boolean ok = initiateTransaction(bill, strategy);
        finalizePayment(bill, ok);
        return ok;
    }

    protected void prepareBill(Bill bill) {
        BillingService.getInstance().prepareBill(bill);
    }

    protected abstract boolean initiateTransaction(Bill bill, PaymentStrategy strategy);

    protected void finalizePayment(Bill bill, boolean ok) {
        bill.setStatus(ok ? PaymentStatus.PAID : PaymentStatus.DECLINED);
    }
}
