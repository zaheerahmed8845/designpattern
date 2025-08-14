package org.example.piece;

import org.example.strategy.PawnMovement;

public class Pawn extends Piece {
    public Pawn(boolean w) {
        super(w, new PawnMovement());
    }
}