package org.example.state;

import org.example.command.MoveCommand;
import org.example.entity.ChessGame;
import org.example.enums.GameStatus;

public class CheckmateState implements GameState {
    private final GameStatus winner;

    public CheckmateState(GameStatus winner) {
        this.winner = winner;
    }

    @Override
    public GameStatus getStatus() {
        return winner;
    }

    @Override
    public boolean handleMove(ChessGame game, MoveCommand cmd) {
        return false;
    }
}
