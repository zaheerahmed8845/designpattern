package org.example.entity;

import org.example.enums.Suit;

import java.util.*;

public class Shoe implements Iterable<Card> {
    private final int deckCount;
    private final Deque<Card> stack = new ArrayDeque<>();

    public Shoe(int deckCount) {
        if (deckCount <= 0) throw new IllegalArgumentException("deckCount must be >= 1");
        this.deckCount = deckCount;
        shuffle();
    }

    /**
     * Rebuild a fresh card pool every time (don’t drain old Deck instances).
     */
    public final void shuffle() {
        stack.clear();
        List<Card> pool = new ArrayList<>(52 * deckCount);

        // Build fresh decks each shuffle
        for (int i = 0; i < deckCount; i++) {
            for (Suit s : Suit.values()) {
                for (int v = 2; v <= 14; v++) {
                    pool.add(new Card(s, v));
                }
            }
        }
        Collections.shuffle(pool);
        // push onto stack so pop() deals from the end
        for (Card c : pool) stack.push(c);
    }

    public Card dealCard() {
        if (stack.isEmpty()) {
            // Defensive: rebuild if someone dealt through the shoe
            shuffle();
        }
        return stack.pop();
    }

    public int remaining() {
        return stack.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Card next() {
                return dealCard();
            }
        };
    }
}
