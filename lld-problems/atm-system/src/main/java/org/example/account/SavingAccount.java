package org.example.account;

public class SavingAccount extends BankAccount {
    public SavingAccount(int accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double getWithdrawalLimit() {
        return Math.min(getAvailableBalance(), 20000.0);
    }
}
