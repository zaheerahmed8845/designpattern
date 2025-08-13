package org.example.state;

import org.example.account.BankAccount;
import org.example.entity.ATM;

public class TransferMoneyState extends ATMState {
    public TransferMoneyState(ATM atm) {
        super(atm);
    }

    @Override
    public void transferMoney() {
        atm.getScreen().showMessage("Enter destination account number:");
        int destAccNo = Integer.parseInt(atm.getKeypad().getInput());
        atm.getScreen().showMessage("Enter amount:");
        double amount = Double.parseDouble(atm.getKeypad().getInput());
        BankAccount from = atm.getCurrentAccount();
        BankAccount to = atm.getBank().findAccount(destAccNo);
        boolean ok = to != null && from.transfer(to, amount);
        atm.getPrinter().printReceipt(ok ? "Transfer OK" : "Transfer failed");
        atm.getScreen().showMessage(ok ? "Transfer successful." : "Transfer failed.");
        returnCard();
    }
}
