package org.example.strategy;

import java.util.List;

public class GroupSearchStrategy implements SearchStrategy {
    @Override
    public List<String> search(String query) {
        return List.of("Group: " + query + " Enthusiasts", "Group: " + query + " Professionals");
    }
}
