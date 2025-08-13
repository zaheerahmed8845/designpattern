package org.example.state;

import org.example.entity.ATM;

public abstract class ATMState {
    protected final ATM atm;

    protected ATMState(ATM atm) {
        this.atm = atm;
    }

    protected void unsupported(String op) {
        throw new IllegalStateException(op + " not allowed in " + getClass().getSimpleName());
    }

    public void insertCard() {
        unsupported("insertCard");
    }

    public void authenticatePin() {
        unsupported("authenticatePin");
    }

    public void selectOperation() {
        unsupported("selectOperation");
    }

    public void cashWithdrawal() {
        unsupported("cashWithdrawal");
    }

    public void displayBalance() {
        unsupported("displayBalance");
    }

    public void changePIN() {
        unsupported("changePIN");
    }

    public void transferMoney() {
        unsupported("transferMoney");
    }

    public void cancelTransaction() {
        atm.returnCard();
        atm.setState(new IdleState(atm));
    }

    public void returnCard() {
        atm.returnCard();
        atm.setState(new IdleState(atm));
    }

    public void exit() { /* no-op */ }
}
