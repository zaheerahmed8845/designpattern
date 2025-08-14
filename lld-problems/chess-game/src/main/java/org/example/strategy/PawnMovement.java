package org.example.strategy;

import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.piece.Piece;


public class PawnMovement implements MovementStrategy {
    @Override
    public boolean canMove(ChessBoard b, Box s, Box e, Piece self) {
        int dir = self.isWhite() ? 1 : -1;
        int startRank = self.isWhite() ? 1 : 6;
        int dx = e.getX() - s.getX(), dy = e.getY() - s.getY();

        // forward one
        if (dx == 0 && dy == dir && !e.isOccupied()) return true;

        // double from start
        if (dx == 0 && dy == 2 * dir && s.getY() == startRank) {
            if (!b.getBox(s.getX(), s.getY() + dir).isOccupied() && !e.isOccupied()) return true;
        }

        // diagonal capture
        if (Math.abs(dx) == 1 && dy == dir && e.isOccupied() &&
                e.getPiece().isWhite() != self.isWhite()) return true;

        // en passant handled at controller level
        return false;
    }
}
