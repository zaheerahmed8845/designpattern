package org.example.entity;

public class Player {
    private final String name;
    private final boolean whiteSide;

    public Player(String name, boolean whiteSide) {
        this.name = name;
        this.whiteSide = whiteSide;
    }

    public String getName() {
        return name;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }
}
