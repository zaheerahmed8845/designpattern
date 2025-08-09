package org.example.entity;

import org.example.enums.Suit;

public class Card {
    private final Suit suit;
    /**
     * faceValue: 2..10; 11=J, 12=Q, 13=K, 14=Ace
     */
    private final int faceValue;

    public Card(Suit suit, int faceValue) {
        if (faceValue < 2 || faceValue > 14) throw new IllegalArgumentException("faceValue must be 2..14");
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    /**
     * Base Blackjack value (Ace=11 here; Hand will demote as needed).
     */
    public int getValue() {
        if (faceValue >= 11 && faceValue <= 13) return 10;
        if (faceValue == 14) return 11; // Ace (soft)
        return faceValue;
    }

    public boolean isAce() {
        return faceValue == 14;
    }

    @Override
    public String toString() {
        String rank = switch (faceValue) {
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> String.valueOf(faceValue);
        };
        return rank + " of " + suit;
    }
}
