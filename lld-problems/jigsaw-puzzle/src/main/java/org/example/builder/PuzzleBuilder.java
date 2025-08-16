package org.example.builder;

import org.example.component.Piece;
import org.example.component.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class PuzzleBuilder {
    private int rows = 2;
    private int cols = 2;
    private final List<Piece> pieces = new ArrayList<>();

    public PuzzleBuilder size(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        return this;
    }

    public PuzzleBuilder addPiece(Piece p) {
        pieces.add(p);
        return this;
    }

    public Puzzle build() {
        Puzzle puzzle = Puzzle.getInstance(rows, cols);
        puzzle.insertPieces(List.copyOf(pieces));
        return puzzle;
    }
}
