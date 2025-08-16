package org.example.match;

public class MatchFactory {
    public enum Type {ODI, TEST, T20}

    public Match create(Type type) {
        return switch (type) {
            case ODI -> new ODI();
            case TEST -> new Test();
            case T20 -> new T20();
        };
    }
}
