package org.example.piece;

import org.example.strategy.KingMovement;

public class King extends Piece {
    public King(boolean w) {
        super(w, new KingMovement());
    }
}