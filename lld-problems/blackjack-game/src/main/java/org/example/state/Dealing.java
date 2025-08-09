package org.example.state;

import org.example.BlackJackGame;
import org.example.entity.Card;

import java.util.Iterator;

public final class Dealing implements GameState {
    @Override
    public void enter(BlackJackGame g) {
        g.resetHands();
        Iterator<Card> it = g.getShoe().iterator();
        // initial deal: player, dealer, player, dealer
        g.getPlayer().getHand().add(it.next());
        g.getDealer().getHand().add(it.next());
        g.getPlayer().getHand().add(it.next());
        g.getDealer().getHand().add(it.next());
        g.getView().showHands(false, g.getPlayer(), g.getDealer());
    }

    @Override
    public void handle(BlackJackGame g) {
    }

    @Override
    public GameState next(BlackJackGame g) {
        return (g.getPlayer().getHand().isBlackjack() || g.getDealer().getHand().isBlackjack())
                ? new Settlement()
                : new PlayersTurn();
    }
}