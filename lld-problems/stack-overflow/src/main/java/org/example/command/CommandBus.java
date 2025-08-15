package org.example.command;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandBus {
    private final Map<Class<?>, CommandHandler<?>> handlers = new HashMap<>();
    private final Set<String> idem = new HashSet<>();

    public <C extends Command> void register(CommandHandler<C> h) {
        handlers.put(h.type(), h);
    }

    public <C extends Command> void submit(C cmd) {
        if (!idem.add(cmd.idempotencyKey())) return;
        execute(cmd);
    }

    @SuppressWarnings("unchecked")
    private <C extends Command> void execute(C cmd) {
        var h = (CommandHandler<C>) handlers.get(cmd.getClass());
        if (h == null) throw new IllegalStateException("No handler");
        h.handle(cmd);
    }
}
