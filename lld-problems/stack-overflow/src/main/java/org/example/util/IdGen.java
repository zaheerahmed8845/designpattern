package org.example.util;

public final class IdGen {
    private static long id = 1000L;

    private IdGen() {
    }

    public static synchronized long next() {
        return ++id;
    }
}