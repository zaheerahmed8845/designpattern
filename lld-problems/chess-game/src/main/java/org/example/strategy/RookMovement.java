package org.example.strategy;

import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.piece.Piece;


public class RookMovement implements MovementStrategy {
    @Override
    public boolean canMove(ChessBoard b, Box s, Box e, Piece self) {
        if (e.isOccupied() && e.getPiece().isWhite() == self.isWhite()) return false;
        if (s.getX() != e.getX() && s.getY() != e.getY()) return false;
        return b.isPathClear(s, e);
    }
}
