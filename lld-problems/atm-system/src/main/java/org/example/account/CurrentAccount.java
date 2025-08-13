package org.example.account;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(int accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double getWithdrawalLimit() {
        return Math.min(getAvailableBalance(), 50000.0);
    }
}
