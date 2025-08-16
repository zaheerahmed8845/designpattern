package org.example.component;

import org.example.entity.Edge;
import org.example.entity.Side;
import org.example.enums.Polarity;
import org.example.enums.SideName;

import java.util.List;

public class Piece implements PuzzleComponent {
    private final String id;
    private final List<Side> sides;

    public Piece(String id, List<Side> sides) {
        if (sides.size() != 4) throw new IllegalArgumentException("Need 4 sides");
        this.id = id;
        this.sides = List.copyOf(sides);
    }

    public String getId() {
        return id;
    }

    public Rotated rotated(int rot) {
        return new Rotated(this, (rot % 4 + 4) % 4);
    }

    public boolean checkCorner() {
        return countFlatSides() == 2;
    }

    public boolean checkEdge() {
        return countFlatSides() == 1;
    }

    public boolean checkMiddle() {
        return countFlatSides() == 0;
    }

    private int countFlatSides() {
        int c = 0;
        for (Side s : sides) if (s.getEdge().getPolarity() == Polarity.FLAT) c++;
        return c;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public void add(PuzzleComponent child) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(PuzzleComponent child) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    public static class Rotated {
        private final Piece base;
        private final int rot;

        Rotated(Piece base, int rot) {
            this.base = base;
            this.rot = rot;
        }

        public Edge edge(SideName side) {
            int idx = Math.floorMod(side.ordinal() - rot, 4);
            return base.sides.get(idx).getEdge();
        }

        public Piece getOriginal() {
            return base;
        }

        public int getRotation() {
            return rot;
        }

        @Override
        public String toString() {
            return base.id + "@rot" + rot;
        }
    }
}
