package org.example.entity;

import java.util.Objects;

public class Badge {
    private final String name;
    private final String description;

    public Badge(String name, String description) {
        this.name = Objects.requireNonNull(name);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
