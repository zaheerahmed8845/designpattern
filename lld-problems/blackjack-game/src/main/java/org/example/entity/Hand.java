package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void add(Card c) {
        cards.add(c);
    }

    public void clear() {
        cards.clear();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int size() {
        return cards.size();
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && getScore() == 21;
    }

    public boolean isBust() {
        return getScore() > 21;
    }

    public boolean isSoft() {
        int total = 0, aces = 0;
        for (Card c : cards) {
            total += c.getValue();
            if (c.isAce()) aces++;
        }
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        // if any Ace still counted as 11, it's soft
        return aces > 0 && total <= 21;
    }

    /**
     * Best Blackjack score (demotes Aces 11->1 as needed).
     */
    public int getScore() {
        int total = 0, aces = 0;
        for (Card c : cards) {
            total += c.getValue();
            if (c.isAce()) aces++;
        }
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    @Override
    public String toString() {
        return cards.toString() + " (" + getScore() + (isSoft() ? " soft" : "") + ")";
    }
}
