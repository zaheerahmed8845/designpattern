package org.example.entity;

import org.example.piece.Piece;

public class Box {
    private final int x, y;
    private Piece piece;

    public Box(int x, int y, Piece p) {
        this.x = x;
        this.y = y;
        this.piece = p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
    }
}
