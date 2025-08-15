package org.example.command;

public interface CommandHandler<C extends Command> {
    Class<C> type();

    void handle(C command);
}

