package org.example.state;

import org.example.entity.ATM;
import org.example.enums.ATMStatus;

public class HasCardState extends ATMState {
    public HasCardState(ATM atm) {
        super(atm);
    }

    @Override
    public void authenticatePin() {
        String input = atm.getKeypad().getInput();
        if (atm.authenticatePin(input)) {
            atm.setStatus(ATMStatus.SelectionOption);
            atm.setState(new SelectOperationState(atm));
            atm.getScreen().showMessage("PIN OK. Select operation.");
        } else {
            atm.getScreen().showMessage("Invalid PIN.");
            returnCard();
        }
    }
}
