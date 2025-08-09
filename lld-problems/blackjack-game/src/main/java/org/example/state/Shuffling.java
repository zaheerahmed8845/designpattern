package org.example.state;

import org.example.BlackJackGame;

public final class Shuffling implements GameState {
    @Override
    public void enter(BlackJackGame g) {
        g.getShoe().shuffle();
        g.getView().prompt("Shuffling...");
    }

    @Override
    public void handle(BlackJackGame g) { /* no-op */ }

    @Override
    public GameState next(BlackJackGame g) {
        return new Dealing();
    }
}
