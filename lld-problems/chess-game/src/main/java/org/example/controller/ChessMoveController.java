package org.example.controller;

import org.example.entity.Box;
import org.example.entity.ChessBoard;
import org.example.piece.Piece;

public class ChessMoveController {
    public boolean validateMove(Piece piece, ChessBoard board, Box start, Box end) {
        if (piece == null || start == null || end == null) return false;
        if (start == end) return false;

        // Strategy-based geometry
        if (!piece.canMove(board, start, end)) return false;

        // TODO: add king-safety validation by simulate/undo
        // TODO: handle castling/en-passant/promotion flags and set MoveType in command (extend API if needed)
        return true;
    }
}
