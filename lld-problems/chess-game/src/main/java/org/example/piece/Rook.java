package org.example.piece;

import org.example.strategy.RookMovement;

public class Rook extends Piece {
    public Rook(boolean w) {
        super(w, new RookMovement());
    }
}

