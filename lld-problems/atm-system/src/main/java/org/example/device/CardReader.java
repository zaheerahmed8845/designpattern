package org.example.device;

import org.example.account.BankAccount;
import org.example.entity.ATM;
import org.example.entity.ATMCard;

public class CardReader implements Device {
    private final ATM atm;

    public CardReader(ATM atm) {
        this.atm = atm;
    }

    /**
     * Simulate reading whatever card the ATM has pending.
     */
    public boolean readCard() {
        ATMCard card = atm.getPendingCard();
        if (card == null) return false;
        BankAccount acc = atm.getBank().accountForCard(card.cardNumber());
        if (acc == null) return false;
        atm.onCardRead(card, acc);
        return true;
    }

    @Override
    public void selfTest() { /* ok */ }
}
