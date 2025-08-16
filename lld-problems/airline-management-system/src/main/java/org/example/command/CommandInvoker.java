package org.example.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandInvoker {
    private final Deque<Command> history = new ArrayDeque<>();

    public void run(Command c) {
        c.execute();
        history.push(c);
        System.out.println("Executed: " + c.name());
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command c = history.pop();
            c.undo();
            System.out.println("Undone: " + c.name());
        }
    }
}
