package org.example.command;

// =============================================================
// COMMAND (encapsulate actions for later)
// =============================================================

public interface Command {
    String idempotencyKey();
}
