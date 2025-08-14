package org.example.state;

import org.example.command.MoveCommand;
import org.example.entity.ChessGame;
import org.example.enums.GameStatus;

public class ActiveState implements GameState {
    @Override
    public GameStatus getStatus() {
        return GameStatus.ACTIVE;
    }

    @Override
    public boolean handleMove(ChessGame game, MoveCommand cmd) {
        boolean ok = cmd.execute();
        if (!ok) return false;

        // Minimal transitions (hooks for real detection):
        if (game.isCheckmate())
            game.setState(new CheckmateState(game.turnIsWhite() ? GameStatus.BLACK_WIN : GameStatus.WHITE_WIN));
        else if (game.isStalemate()) game.setState(new StalemateState());
        else if (game.isCheck()) game.setState(new CheckState());
        else game.swapTurn();
        return true;
    }
}
