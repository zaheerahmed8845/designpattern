package org.example.state;

import org.example.entity.ATM;
import org.example.enums.ATMStatus;

public class IdleState extends ATMState {
    public IdleState(ATM atm) {
        super(atm);
    }

    @Override
    public void insertCard() {
        boolean ok = atm.getCardReader().readCard();
        if (ok) {
            atm.setStatus(ATMStatus.HasCard);
            atm.setState(new HasCardState(atm));
            atm.getScreen().showMessage("Card accepted. Please enter PIN.");
        } else {
            atm.getScreen().showMessage("Card read failed.");
        }
    }
}
