package org.example.state;

import org.example.command.MoveCommand;
import org.example.entity.ChessGame;
import org.example.enums.GameStatus;

public class CheckState implements GameState {
    @Override
    public GameStatus getStatus() {
        return GameStatus.ACTIVE;
    } // still active, but in check

    @Override
    public boolean handleMove(ChessGame game, MoveCommand cmd) {
        boolean ok = cmd.execute();
        if (!ok) return false;
        if (game.isCheckmate())
            game.setState(new CheckmateState(game.turnIsWhite() ? GameStatus.BLACK_WIN : GameStatus.WHITE_WIN));
        else if (game.isStalemate()) game.setState(new StalemateState());
        else game.setState(new ActiveState());
        game.swapTurn();
        return true;
    }
}
