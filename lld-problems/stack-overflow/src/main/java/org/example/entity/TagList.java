package org.example.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TagList {
    private final Map<Tag, Integer> tagsCount = new HashMap<>();

    public Map<Tag, Integer> getTagsCount() {
        return Collections.unmodifiableMap(tagsCount);
    }

    public void incrementTagCount(Tag tag) {
        tagsCount.merge(tag, 1, Integer::sum);
    }

    public void decrementTagCount(Tag tag) {
        tagsCount.computeIfPresent(tag, (t, c) -> c > 1 ? c - 1 : null);
    }
}
