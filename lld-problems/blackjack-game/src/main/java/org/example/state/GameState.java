package org.example.state;

import org.example.BlackJackGame;

public interface GameState {
    void enter(BlackJackGame ctx);

    void handle(BlackJackGame ctx);

    GameState next(BlackJackGame ctx);

    default String name() {
        return getClass().getSimpleName();
    }
}