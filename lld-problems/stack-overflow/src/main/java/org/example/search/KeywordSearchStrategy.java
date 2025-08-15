package org.example.search;

import org.example.entity.Question;

import java.util.List;

public final class KeywordSearchStrategy implements SearchStrategy {
    private final Search catalog;

    public KeywordSearchStrategy(Search c) {
        this.catalog = c;
    }

    public List<Question> search(String query) {
        return catalog.searchByWords(query);
    }
}
