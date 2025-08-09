package org.example.entity;

import org.example.enums.AccountStatus;

public class BlackjackPlayer extends Player {
    private int bet;

    public BlackjackPlayer(String id, String password, double balance, Person person) {
        super(id, password, balance, AccountStatus.ACTIVE, person);
    }

    public boolean placeBet(int amount) {
        if (amount <= 0) return false;
        if (debit(amount)) {
            this.bet = amount;
            return true;
        }
        return false;
    }

    /**
     * Pay winnings (includes returning principal) and clear bet.
     */
    public void payout(int amount) {
        credit(amount);
        this.bet = 0;
    }

    /**
     * Lose current bet without payout.
     */
    public void loseBet() {
        this.bet = 0;
    }

    public int getBet() {
        return bet;
    }
}
