package org.example.strategy;

import org.example.VendingMachine;

public class CashPayment implements PaymentStrategy {
    private final VendingMachine machine;

    public CashPayment(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public boolean authorize(double amount) {
        // User's inserted amount (tracked by machine) must be >= price.
        return machine.getCurrentAmount() + 1e-6 >= amount;
    }

    @Override
    public boolean capture(double amount) {
        // Machine keeps the price portion; change handled separately.
        return true;
    }

    @Override
    public void refund(double amount) {
        // Actual coin return handled by machine.returnChange(...)
    }

    @Override
    public String name() {
        return "CASH";
    }
}
