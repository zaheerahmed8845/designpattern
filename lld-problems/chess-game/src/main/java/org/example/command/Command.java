package org.example.command;

public interface Command {
    boolean execute();

    void undo();
}
