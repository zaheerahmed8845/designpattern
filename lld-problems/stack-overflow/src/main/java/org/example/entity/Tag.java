package org.example.entity;

import java.util.Locale;
import java.util.Objects;

public class Tag {
    private final String name;
    private final String description;

    public Tag(String name, String description) {
        this.name = Objects.requireNonNull(name);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Tag t) && name.equalsIgnoreCase(t.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase(Locale.ROOT).hashCode();
    }

    @Override
    public String toString() {
        return "#" + name;
    }
}
