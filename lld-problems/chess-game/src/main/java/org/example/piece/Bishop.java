package org.example.piece;

import org.example.strategy.BishopMovement;

public class Bishop extends Piece {
    public Bishop(boolean w) {
        super(w, new BishopMovement());
    }
}