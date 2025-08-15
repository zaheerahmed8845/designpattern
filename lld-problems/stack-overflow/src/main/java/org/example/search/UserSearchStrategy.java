package org.example.search;

import org.example.entity.Question;

import java.util.List;

public final class UserSearchStrategy implements SearchStrategy {
    private final Search catalog;

    public UserSearchStrategy(Search c) {
        this.catalog = c;
    }

    public List<Question> search(String query) {
        return catalog.searchByUsers(query);
    }
}