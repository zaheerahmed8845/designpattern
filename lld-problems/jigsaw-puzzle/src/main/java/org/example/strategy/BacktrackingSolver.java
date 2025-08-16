package org.example.strategy;

import org.example.component.Piece;
import org.example.component.Puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BacktrackingSolver implements SolverStrategy {
    @Override
    public Puzzle solve(Puzzle puzzle, List<Piece> freePieces, MatchStrategy matcher) {
        var used = new HashSet<String>();
        if (!dfs(puzzle, freePieces, used, matcher)) throw new IllegalStateException("No solution");
        return puzzle;
    }

    private boolean dfs(Puzzle puzzle, List<Piece> free, Set<String> used, MatchStrategy match) {
        var pos = puzzle.firstEmpty();
        if (pos == null) return true;

        for (Piece p : free) {
            if (used.contains(p.getId())) continue;
            for (int rot = 0; rot < 4; rot++) {
                var r = p.rotated(rot);
                puzzle.place(r, pos);
                used.add(p.getId());
                if (dfs(puzzle, free, used, match)) return true;
                used.remove(p.getId());
                puzzle.remove(pos);
            }
        }
        return false;
    }
}
