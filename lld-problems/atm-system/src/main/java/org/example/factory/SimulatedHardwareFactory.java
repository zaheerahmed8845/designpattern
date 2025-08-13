package org.example.factory;

import org.example.device.*;
import org.example.entity.ATM;

public class SimulatedHardwareFactory extends HardwareFactory {
    @Override
    public CardReader createCardReader(ATM atm) {
        return new CardReader(atm);
    }

    @Override
    public Keypad createKeypad() {
        return new Keypad();
    }

    @Override
    public Screen createScreen() {
        return new Screen();
    }

    @Override
    public Printer createPrinter() {
        return new Printer();
    }

    @Override
    public CashDispenser createCashDispenser(ATM atm) {
        return new CashDispenser(atm);
    }
}
