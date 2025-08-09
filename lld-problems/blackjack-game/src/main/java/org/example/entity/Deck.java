package org.example.entity;


import org.example.enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>(52);

    public Deck() {
        for (Suit s : Suit.values()) {
            for (int v = 2; v <= 14; v++) {
                cards.add(new Card(s, v));
            }
        }
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Draw top card; returns null if empty.
     */
    public Card getCard() {
        return cards.isEmpty() ? null : cards.remove(cards.size() - 1);
    }

    public int remaining() {
        return cards.size();
    }
}
