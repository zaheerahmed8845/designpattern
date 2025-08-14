package org.example.piece;

import org.example.strategy.QueenMovement;

public class Queen extends Piece {
    public Queen(boolean w) {
        super(w, new QueenMovement());
    }
}