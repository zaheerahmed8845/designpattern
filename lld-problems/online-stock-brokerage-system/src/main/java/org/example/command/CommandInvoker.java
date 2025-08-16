package org.example.command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CommandInvoker {
    private final BlockingQueue<Command> queue = new LinkedBlockingQueue<>();

    public void submit(Command c) {
        queue.offer(c);
    }

    public void runNext() {
        Command c = queue.poll();
        if (c != null) c.execute();
    }

    public void runAll() {
        Command c;
        while ((c = queue.poll()) != null) {
            c.execute();
        }
    }
}
