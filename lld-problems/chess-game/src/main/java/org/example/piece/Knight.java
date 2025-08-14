package org.example.piece;

import org.example.strategy.KnightMovement;

public class Knight extends Piece {
    public Knight(boolean w) {
        super(w, new KnightMovement());
    }
}