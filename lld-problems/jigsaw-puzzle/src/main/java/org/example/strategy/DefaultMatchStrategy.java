package org.example.strategy;

import org.example.entity.Edge;
import org.example.enums.Polarity;

public class DefaultMatchStrategy implements MatchStrategy {
    @Override
    public boolean match(Edge a, Edge b, boolean atBorder) {
        if (a.getPolarity() == Polarity.FLAT || b.getPolarity() == Polarity.FLAT) return false;
        if (a.getProfileId() != b.getProfileId()) return false;
        return (a.getPolarity() == Polarity.TAB && b.getPolarity() == Polarity.BLANK) ||
                (a.getPolarity() == Polarity.BLANK && b.getPolarity() == Polarity.TAB);
    }
}
