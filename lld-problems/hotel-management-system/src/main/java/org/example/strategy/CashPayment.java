package org.example.strategy;

public class CashPayment extends AbstractPaymentProcessor {
    private final double cashTendered;

    public CashPayment(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    @Override
    protected boolean doCharge(double amount) {
        return cashTendered >= amount;
    }
}
