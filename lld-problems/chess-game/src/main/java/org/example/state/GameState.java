package org.example.state;

import org.example.command.MoveCommand;
import org.example.entity.ChessGame;
import org.example.enums.GameStatus;

public interface GameState {
    GameStatus getStatus();

    boolean handleMove(ChessGame game, MoveCommand cmd);
}
