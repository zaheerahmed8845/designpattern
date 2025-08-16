package org.example.entity;

import org.example.strategy.SearchStrategy;
import org.example.strategy.UserSearchStrategy;

import java.util.List;

public class SearchService {
    private static final SearchService INSTANCE = new SearchService();
    private SearchStrategy strategy = new UserSearchStrategy();

    private SearchService() {
    }

    public static SearchService getInstance() {
        return INSTANCE;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> search(String query) {
        return strategy.search(query);
    }
}
