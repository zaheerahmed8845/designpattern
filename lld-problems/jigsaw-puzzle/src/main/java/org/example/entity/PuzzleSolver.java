package org.example.entity;

import org.example.component.Puzzle;
import org.example.strategy.MatchStrategy;
import org.example.strategy.SolverStrategy;

public class PuzzleSolver {
    private final SolverStrategy strategy;
    private final MatchStrategy matcher;

    public PuzzleSolver(SolverStrategy strategy, MatchStrategy matcher) {
        this.strategy = strategy;
        this.matcher = matcher;
    }

    public Puzzle matchPieces(Puzzle puzzle) {
        return strategy.solve(puzzle, puzzle.getFreePieces(), matcher);
    }
}
