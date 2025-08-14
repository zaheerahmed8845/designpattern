package org.example.piece;


import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.strategy.MovementStrategy;

public abstract class Piece {
    protected boolean killed = false;
    protected final boolean white;
    protected final MovementStrategy strategy;

    protected Piece(boolean white, MovementStrategy strategy) {
        this.white = white;
        this.strategy = strategy;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean k) {
        killed = k;
    }

    public boolean canMove(ChessBoard board, Box start, Box end) {
        return strategy.canMove(board, start, end, this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName().charAt(0) + (white ? "w" : "b");
    }
}
