package org.example.strategy;

import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.piece.Piece;


public class KnightMovement implements MovementStrategy {
    @Override
    public boolean canMove(ChessBoard b, Box s, Box e, Piece self) {
        if (e.isOccupied() && e.getPiece().isWhite() == self.isWhite()) return false;
        int dx = Math.abs(s.getX() - e.getX()), dy = Math.abs(s.getY() - e.getY());
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }
}
