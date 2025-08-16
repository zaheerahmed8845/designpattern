package org.example.strategy;

import java.util.List;

public class UserSearchStrategy implements SearchStrategy {
    @Override
    public List<String> search(String query) {
        // stubbed result set
        return List.of("User: " + query + " Khan", "User: " + query + " Patel");
    }
}
