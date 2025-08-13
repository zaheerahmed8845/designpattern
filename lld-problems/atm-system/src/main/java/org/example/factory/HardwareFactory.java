package org.example.factory;

import org.example.device.*;
import org.example.entity.ATM;

public abstract class HardwareFactory {
    public abstract CardReader createCardReader(ATM atm);

    public abstract Keypad createKeypad();

    public abstract Screen createScreen();

    public abstract Printer createPrinter();

    public abstract CashDispenser createCashDispenser(ATM atm);

    public static HardwareFactory simulated() {
        return new SimulatedHardwareFactory();
    }
}
