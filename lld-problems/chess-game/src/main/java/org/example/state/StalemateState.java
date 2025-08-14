package org.example.state;

import org.example.command.MoveCommand;
import org.example.entity.ChessGame;
import org.example.enums.GameStatus;

public class StalemateState implements GameState {
    @Override
    public GameStatus getStatus() {
        return GameStatus.STALEMATE;
    }

    @Override
    public boolean handleMove(ChessGame game, MoveCommand cmd) {
        return false;
    }
}
