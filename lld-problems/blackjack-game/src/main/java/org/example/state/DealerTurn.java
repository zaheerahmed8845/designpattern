package org.example.state;

import org.example.BlackJackGame;

public final class DealerTurn implements GameState {
    @Override
    public void enter(BlackJackGame g) {
        g.getView().showHands(true, g.getPlayer(), g.getDealer());
        g.playDealerPolicy(); // draw to 17 (stands on all 17s now)
        g.getView().showHands(true, g.getPlayer(), g.getDealer());
    }

    @Override
    public void handle(BlackJackGame g) {
    }

    @Override
    public GameState next(BlackJackGame g) {
        return new Settlement();
    }
}
