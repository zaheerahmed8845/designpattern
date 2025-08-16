package org.example.strategy;

import org.example.entity.Edge;

public interface MatchStrategy {
    boolean match(Edge a, Edge b, boolean atBorder);
}
