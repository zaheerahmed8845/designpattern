package org.example.strategy;

import org.example.account.BankAccount;
import org.example.entity.ATM;

public class WithdrawStrategy implements TransactionStrategy {
    @Override
    public boolean execute(ATM atm) {
        String input = atm.getKeypad().getInput();
        double amount = Double.parseDouble(input);
        BankAccount account = atm.getCurrentAccount();
        if (amount <= 0 || amount > account.getWithdrawalLimit()) return false;
        if (amount > account.getAvailableBalance()) return false;
        if (!atm.hasCash(amount)) return false;
        boolean ok = account.withdraw(amount) && atm.getCashDispenser().dispenseCash(amount);
        if (ok) atm.debitATMBalance(amount);
        return ok;
    }

    @Override
    public String name() {
        return "Withdraw";
    }
}
