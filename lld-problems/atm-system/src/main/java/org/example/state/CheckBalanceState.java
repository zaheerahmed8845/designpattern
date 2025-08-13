package org.example.state;

import org.example.entity.ATM;
import org.example.strategy.BalanceStrategy;

public class CheckBalanceState extends ATMState {
    public CheckBalanceState(ATM atm) {
        super(atm);
    }

    @Override
    public void displayBalance() {
        new BalanceStrategy().execute(atm);
        atm.getPrinter().printReceipt("Balance printed");
        returnCard();
    }
}
