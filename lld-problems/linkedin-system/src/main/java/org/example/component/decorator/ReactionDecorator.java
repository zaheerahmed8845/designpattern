package org.example.component.decorator;

import org.example.component.ContentComponent;

import java.util.HashMap;
import java.util.Map;

public class ReactionDecorator extends ContentDecorator {
    private final Map<String, Integer> reactionBreakdown = new HashMap<>();

    public ReactionDecorator(ContentComponent inner) {
        super(inner);
    }

    @Override
    public void addReaction(String type) {
        super.addReaction(type);
        reactionBreakdown.merge(type, 1, Integer::sum);
    }

    public Map<String, Integer> getReactionBreakdown() {
        return reactionBreakdown;
    }
}
