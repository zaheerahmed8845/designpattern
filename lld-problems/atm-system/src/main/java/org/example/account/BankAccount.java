package org.example.account;

public abstract class BankAccount {
    private final int accountNumber;
    private double totalBalance;
    private double availableBalance;

    protected BankAccount(int accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.totalBalance = openingBalance;
        this.availableBalance = openingBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > availableBalance) return false;
        availableBalance -= amount;
        totalBalance -= amount;
        return true;
    }

    public boolean transfer(BankAccount toAccount, double amount) {
        if (toAccount == null || amount <= 0 || amount > availableBalance) return false;
        availableBalance -= amount;
        totalBalance -= amount;
        toAccount.credit(amount);
        return true;
    }

    protected void credit(double amount) {
        totalBalance += amount;
        availableBalance += amount;
    }

    public abstract double getWithdrawalLimit();
}
