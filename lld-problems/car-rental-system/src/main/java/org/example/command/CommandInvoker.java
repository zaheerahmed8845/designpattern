package org.example.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandInvoker {
    private final List<Command> history = new ArrayList<>();

    public boolean run(Command cmd) {
        boolean ok = cmd.execute();
        if (ok) history.add(cmd);
        return ok;
    }

    public List<Command> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
