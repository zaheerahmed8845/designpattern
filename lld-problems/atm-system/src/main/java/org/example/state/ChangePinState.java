package org.example.state;

import org.example.entity.ATM;

public class ChangePinState extends ATMState {
    public ChangePinState(ATM atm) {
        super(atm);
    }

    @Override
    public void changePIN() {
        atm.getScreen().showMessage("Enter new PIN:");
        String p1 = atm.getKeypad().getInput();
        atm.getScreen().showMessage("Confirm new PIN:");
        String p2 = atm.getKeypad().getInput();
        boolean ok = p1.equals(p2) && atm.changePin(p1);
        atm.getPrinter().printReceipt(ok ? "PIN changed" : "PIN change failed");
        atm.getScreen().showMessage(ok ? "PIN updated." : "Failed to update PIN.");
        returnCard();
    }
}
