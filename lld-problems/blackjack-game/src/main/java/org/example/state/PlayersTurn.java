package org.example.state;

import org.example.BlackJackGame;

public final class PlayersTurn implements GameState {
    @Override
    public void enter(BlackJackGame g) {
        g.clearTurnDone();
        g.getView().prompt("Player's turn: choose action [hit|stand]");
    }

    @Override
    public void handle(BlackJackGame g) { /* wait for onPlayerAction */ }

    @Override
    public GameState next(BlackJackGame g) {
        return g.isTurnDone() ? new DealerTurn() : this;
    }
}
