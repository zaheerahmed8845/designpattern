package org.example.strategy;

import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.piece.Piece;

public interface MovementStrategy {
    boolean canMove(ChessBoard board, Box start, Box end, Piece self);
}
