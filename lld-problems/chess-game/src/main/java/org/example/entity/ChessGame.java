package org.example.entity;


import org.example.command.MoveCommand;
import org.example.controller.ChessMoveController;
import org.example.enums.GameStatus;
import org.example.observer.BoardObserver;
import org.example.state.ActiveState;
import org.example.state.CheckState;
import org.example.state.GameState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChessGame implements Iterable<Move> {
    private final Player white, black;
    private Player currentTurn;
    private final ChessMoveController controller = new ChessMoveController();
    private final List<Move> moveHistory = new ArrayList<>();
    private GameState state = new ActiveState();

    public ChessGame(Player white, Player black, BoardObserver view) {
        this.white = white;
        this.black = black;
        this.currentTurn = white.isWhiteSide() ? white : black;
        ChessBoard.getInstance().addObserver(view);
    }

    // Iterator pattern: iterate over moves
    @Override
    public Iterator<Move> iterator() {
        return moveHistory.iterator();
    }

    public boolean playMove(int fromX, int fromY, int toX, int toY) {
        if (!(state instanceof ActiveState || state instanceof CheckState)) return false;
        MoveCommand cmd = new MoveCommand(this, currentTurn, fromX, fromY, toX, toY);
        boolean ok = state.handleMove(this, cmd);
        return ok;
    }

    // Hooks used by Command/State
    public void recordMove(Move m) {
        moveHistory.add(m);
    }

    public void popLastMove() {
        if (!moveHistory.isEmpty()) moveHistory.remove(moveHistory.size() - 1);
    }

    public Move peekLastMove() {
        return moveHistory.isEmpty() ? null : moveHistory.get(moveHistory.size() - 1);
    }

    public void swapTurn() {
        currentTurn = (currentTurn == white) ? black : white;
    }

    public boolean turnIsWhite() {
        return currentTurn.isWhiteSide();
    }

    public ChessMoveController getController() {
        return controller;
    }

    // State management
    public void setState(GameState s) {
        this.state = s;
    }

    public GameStatus getStatus() {
        return state.getStatus();
    }

    // Stubs for detection (extend later)
    public boolean isCheck() {
        return false;
    }

    public boolean isCheckmate() {
        return false;
    }

    public boolean isStalemate() {
        return false;
    }
}
