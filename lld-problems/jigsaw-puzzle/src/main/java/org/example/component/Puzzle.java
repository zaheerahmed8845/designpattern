package org.example.component;

import java.util.ArrayList;
import java.util.List;

public class Puzzle implements PuzzleComponent {
    private static Puzzle INSTANCE;

    public static synchronized Puzzle getInstance(int rows, int cols) {
        if (INSTANCE == null) INSTANCE = new Puzzle(rows, cols);
        return INSTANCE;
    }

    private final int rows, cols;
    private final Placement[][] board;
    private final List<Piece> free;
    private final List<PuzzleComponent> children = new ArrayList<>();

    private Puzzle(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Placement[rows][cols];
        this.free = new ArrayList<>();
    }

    @Override
    public int size() {
        return rows * cols;
    }

    @Override
    public void add(PuzzleComponent child) {
        children.add(child);
    }

    @Override
    public void remove(PuzzleComponent child) {
        children.remove(child);
    }

    @Override
    public boolean isComplete() {
        for (var row : board) for (var cell : row) if (cell == null) return false;
        return true;
    }

    public void insertPieces(List<Piece> pieces) {
        free.clear();
        free.addAll(pieces);
        for (Piece p : pieces) add(p);
    }

    public List<Piece> getFreePieces() {
        return free;
    }

    public void place(Piece.Rotated rotated, Cell pos) {
        board[pos.row()][pos.col()] = new Placement(rotated);
    }

    public void remove(Cell pos) {
        board[pos.row()][pos.col()] = null;
    }

    public Placement getPlacement(int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) return null;
        return board[row][col];
    }

    public Cell firstEmpty() {
        for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) if (board[r][c] == null) return new Cell(r, c);
        return null;
    }

    public record Placement(Piece.Rotated rotated) {
    }

    public record Cell(int row, int col) {
    }
}
