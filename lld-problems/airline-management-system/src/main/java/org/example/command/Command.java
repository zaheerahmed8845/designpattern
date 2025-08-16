package org.example.command;

public interface Command {
    void execute();

    default void undo() {
    }

    default String name() {
        return getClass().getSimpleName();
    }
}
