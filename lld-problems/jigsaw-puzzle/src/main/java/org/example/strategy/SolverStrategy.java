package org.example.strategy;

import org.example.component.Piece;
import org.example.component.Puzzle;

import java.util.List;

public interface SolverStrategy {
    Puzzle solve(Puzzle puzzle, List<Piece> freePieces, MatchStrategy matcher);
}
