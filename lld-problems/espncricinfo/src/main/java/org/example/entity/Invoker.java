package org.example.entity;

import org.example.command.Command;

import java.util.ArrayDeque;
import java.util.Queue;

public class Invoker {
    private final Queue<Command> queue = new ArrayDeque<>();

    public void submit(Command c) {
        queue.offer(c);
    }

    public void runAll() {
        while (!queue.isEmpty()) queue.poll().execute();
    }
}
