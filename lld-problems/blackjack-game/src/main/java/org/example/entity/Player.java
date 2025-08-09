package org.example.entity;

import org.example.enums.AccountStatus;

public abstract class Player {
    protected final String id;
    protected String password;
    protected double balance;
    protected AccountStatus status;
    protected final Person person;
    protected final Hand hand;

    protected Player(String id, String password, double balance, AccountStatus status, Person person) {
        this.id = id;
        this.password = password;
        this.balance = balance;
        this.status = status;
        this.person = person;
        this.hand = new Hand();
    }

    public boolean resetPassword() {
        this.password = "TEMP-" + System.nanoTime();
        return true;
    }

    public Hand getHand() {
        return hand;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public boolean debit(double amount) {
        if (amount < 0) return false;
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }
}
