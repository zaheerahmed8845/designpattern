package org.example.search;

import org.example.entity.Question;

import java.util.List;

public final class SearchService { // context
    public List<Question> search(String query, SearchStrategy strategy) {
        return strategy.search(query);
    }
}
