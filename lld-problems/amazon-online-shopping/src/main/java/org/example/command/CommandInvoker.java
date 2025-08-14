package org.example.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private final List<Command> history = new ArrayList<>();

    public boolean submit(Command c) {
        boolean ok = c.execute();
        history.add(c);
        System.out.println("Executed: " + c.name() + " -> " + ok);
        return ok;
    }

    public List<Command> history() {
        return List.copyOf(history);
    }
}
