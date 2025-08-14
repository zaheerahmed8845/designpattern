package org.example.entity;

import org.example.enums.MoveType;
import org.example.piece.Piece;

public class Move {
    private final Box start, end;
    private final Piece pieceMoved;
    private final Piece pieceKilled; // nullable
    private final Player player;
    private final MoveType moveType;

    public Move(Box start, Box end, Piece moved, Piece killed, Player player, MoveType type) {
        this.start = start;
        this.end = end;
        this.pieceMoved = moved;
        this.pieceKilled = killed;
        this.player = player;
        this.moveType = type;
    }

    public Box getStart() {
        return start;
    }

    public Box getEnd() {
        return end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public Player getPlayer() {
        return player;
    }

    public MoveType getMoveType() {
        return moveType;
    }
}
