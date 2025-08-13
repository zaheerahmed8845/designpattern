package org.example.strategy;

import org.example.entity.ATM;

public class BalanceStrategy implements TransactionStrategy {
    @Override
    public boolean execute(ATM atm) {
        atm.getScreen().showMessage("Available balance: " + atm.getCurrentAccount().getAvailableBalance());
        return true;
    }

    @Override
    public String name() {
        return "BalanceInquiry";
    }
}
