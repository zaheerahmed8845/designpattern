package org.example.component;

public interface PuzzleComponent {
    int size();

    void add(PuzzleComponent child);

    void remove(PuzzleComponent child);

    boolean isComplete();
}