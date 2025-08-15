package org.example.strategy;

import org.example.entity.Bill;

public class CashPayment implements PaymentStrategy {
    private final double cashTendered;

    public CashPayment(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    @Override
    public boolean charge(Bill bill) {
        return cashTendered >= bill.totalDue();
    }
}
