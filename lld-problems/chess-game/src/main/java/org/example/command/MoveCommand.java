package org.example.command;

import org.example.entity.*;
import org.example.enums.MoveType;
import org.example.piece.Piece;

public class MoveCommand implements Command {
    private final ChessGame game;
    private final Player player;
    private final int fromX, fromY, toX, toY;
    private MoveType moveType = MoveType.NORMAL;
    private Piece moved, captured;
    private Box start, end;

    public MoveCommand(ChessGame game, Player player, int fromX, int fromY, int toX, int toY) {
        this.game = game;
        this.player = player;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    @Override
    public boolean execute() {
        ChessBoard board = ChessBoard.getInstance();
        start = board.getBox(fromX, fromY);
        end = board.getBox(toX, toY);
        if (!start.isOccupied()) return false;
        moved = start.getPiece();

        // side-to-move
        if (moved.isWhite() != player.isWhiteSide()) return false;

        if (!game.getController().validateMove(moved, board, start, end)) return false;

        captured = end.getPiece();
        end.setPiece(moved);
        start.setPiece(null);
        if (captured != null) captured.setKilled(true);

        Move move = new Move(start, end, moved, captured, player, moveType);
        game.recordMove(move);
        board.setLastMove(move);
        return true;
    }

    @Override
    public void undo() {
        ChessBoard board = ChessBoard.getInstance();
        start.setPiece(moved);
        end.setPiece(captured);
        if (captured != null) captured.setKilled(false);
        game.popLastMove();
        board.setLastMove(game.peekLastMove());
    }
}
