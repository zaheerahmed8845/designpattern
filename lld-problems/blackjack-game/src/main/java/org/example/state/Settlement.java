package org.example.state;

import org.example.BlackJackGame;

public final class Settlement implements GameState {
    @Override
    public void enter(BlackJackGame g) {
        g.settleAll();
    }

    @Override
    public void handle(BlackJackGame g) {
        g.getView().showResults(g.resultsText());
    }

    @Override
    public GameState next(BlackJackGame g) {
        return g.shuffleNeeded() ? new Shuffling() : new Dealing();
    }
}