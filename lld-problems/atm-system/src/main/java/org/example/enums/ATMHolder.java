package org.example.enums;

import org.example.entity.ATM;
import org.example.entity.Bank;
import org.example.factory.HardwareFactory;

public enum ATMHolder {
    INSTANCE;
    private ATM atm;

    public synchronized void initialize(Bank bank, HardwareFactory factory) {
        if (atm == null) atm = new ATM(bank, factory);
    }

    public ATM get() {
        if (atm == null) throw new IllegalStateException("ATM not initialized");
        return atm;
    }
}
