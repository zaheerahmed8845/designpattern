package org.example.device;

import org.example.entity.ATM;

public class CashDispenser implements Device {
    private final ATM atm;

    public CashDispenser(ATM atm) {
        this.atm = atm;
    }

    public boolean dispenseCash(double amount) {
        return atm.hasCash(amount);
    }

    @Override
    public void selfTest() { /* ok */ }
}
