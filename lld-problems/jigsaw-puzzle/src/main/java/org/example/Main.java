package org.example;

import org.example.builder.PuzzleBuilder;
import org.example.component.Piece;
import org.example.component.Puzzle;
import org.example.entity.Edge;
import org.example.entity.PuzzleSolver;
import org.example.entity.Side;
import org.example.enums.Polarity;
import org.example.strategy.BacktrackingSolver;
import org.example.strategy.DefaultMatchStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Edge FLAT = new Edge(0, Polarity.FLAT);

        Piece A = new Piece("A", List.of(
                new Side(FLAT), new Side(new Edge(1, Polarity.TAB)),
                new Side(new Edge(2, Polarity.TAB)), new Side(FLAT)));

        Piece B = new Piece("B", List.of(
                new Side(FLAT), new Side(FLAT),
                new Side(new Edge(3, Polarity.TAB)), new Side(new Edge(1, Polarity.BLANK))));

        Piece C = new Piece("C", List.of(
                new Side(new Edge(2, Polarity.BLANK)), new Side(new Edge(4, Polarity.TAB)),
                new Side(FLAT), new Side(FLAT)));

        Piece D = new Piece("D", List.of(
                new Side(new Edge(3, Polarity.BLANK)), new Side(FLAT),
                new Side(FLAT), new Side(new Edge(4, Polarity.BLANK))));

        Puzzle puzzle = new PuzzleBuilder().size(2, 2).addPiece(A).addPiece(B).addPiece(C).addPiece(D).build();

        PuzzleSolver solver = new PuzzleSolver(new BacktrackingSolver(), new DefaultMatchStrategy());
        solver.matchPieces(puzzle);

        System.out.println("Solved puzzle: " + puzzle.isComplete());
    }
}