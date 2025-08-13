package org.example.state;

import org.example.entity.ATM;
import org.example.strategy.WithdrawStrategy;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState(ATM atm) {
        super(atm);
    }

    @Override
    public void cashWithdrawal() {
        boolean ok = new WithdrawStrategy().execute(atm);
        atm.getPrinter().printReceipt(ok ? "Withdrawal success" : "Withdrawal failed");
        atm.getScreen().showMessage(ok ? "Please collect your cash." : "Unable to dispense cash.");
        returnCard();
    }
}
