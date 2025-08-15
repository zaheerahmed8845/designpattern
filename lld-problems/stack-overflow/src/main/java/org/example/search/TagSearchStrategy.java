package org.example.search;

import org.example.entity.Question;

import java.util.List;

public final class TagSearchStrategy implements SearchStrategy {
    private final Search catalog;

    public TagSearchStrategy(Search c) {
        this.catalog = c;
    }

    public List<Question> search(String query) {
        return catalog.searchByTags(query);
    }
}
