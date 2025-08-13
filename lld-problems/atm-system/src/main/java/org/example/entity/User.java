package org.example.entity;

import org.example.account.BankAccount;

public class User {
    private ATMCard card;
    private BankAccount account;

    public User(BankAccount account) {
        this.account = account;
    }

    public ATMCard getCard() {
        return card;
    }

    public void setCard(ATMCard card) {
        this.card = card;
    }

    public BankAccount getAccount() {
        return account;
    }
}
