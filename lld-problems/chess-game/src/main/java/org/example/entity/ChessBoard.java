package org.example.entity;

import org.example.observer.BoardObserver;
import org.example.piece.*;

import java.util.ArrayList;
import java.util.List;

public final class ChessBoard {
    private static final ChessBoard INSTANCE = new ChessBoard();
    private final Box[][] boxes = new Box[8][8];
    private final List<BoardObserver> observers = new ArrayList<>();
    private Move lastMove; // helpful for en passant, view, etc.

    private ChessBoard() {
        resetBoard();
    }

    public static ChessBoard getInstance() {
        return INSTANCE;
    }

    public void resetBoard() {
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++)
                boxes[x][y] = new Box(x, y, null);

        for (int x = 0; x < 8; x++) {
            boxes[x][1].setPiece(new Pawn(true));
            boxes[x][6].setPiece(new Pawn(false));
        }
        boxes[0][0].setPiece(new Rook(true));
        boxes[7][0].setPiece(new Rook(true));
        boxes[0][7].setPiece(new Rook(false));
        boxes[7][7].setPiece(new Rook(false));
        boxes[1][0].setPiece(new Knight(true));
        boxes[6][0].setPiece(new Knight(true));
        boxes[1][7].setPiece(new Knight(false));
        boxes[6][7].setPiece(new Knight(false));
        boxes[2][0].setPiece(new Bishop(true));
        boxes[5][0].setPiece(new Bishop(true));
        boxes[2][7].setPiece(new Bishop(false));
        boxes[5][7].setPiece(new Bishop(false));
        boxes[3][0].setPiece(new Queen(true));
        boxes[3][7].setPiece(new Queen(false));
        boxes[4][0].setPiece(new King(true));
        boxes[4][7].setPiece(new King(false));
        lastMove = null;
        notifyObservers();
    }

    public Box getBox(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) throw new IllegalArgumentException("Out of bounds");
        return boxes[x][y];
    }

    public boolean isPathClear(Box start, Box end) {
        int dx = Integer.compare(end.getX(), start.getX());
        int dy = Integer.compare(end.getY(), start.getY());
        int x = start.getX() + dx, y = start.getY() + dy;
        while (x != end.getX() || y != end.getY()) {
            if (getBox(x, y).isOccupied()) return false;
            x += dx;
            y += dy;
        }
        return true;
    }

    // Observer wiring
    public void addObserver(BoardObserver o) {
        observers.add(o);
    }

    public void removeObserver(BoardObserver o) {
        observers.remove(o);
    }

    public void setLastMove(Move m) {
        this.lastMove = m;
        notifyObservers();
    }

    public Move getLastMove() {
        return lastMove;
    }

    private void notifyObservers() {
        for (var o : observers) o.onBoardChanged(this, lastMove);
    }
}
