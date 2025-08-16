package org.example.strategy;

import java.util.List;

public class JobSearchStrategy implements SearchStrategy {
    @Override
    public List<String> search(String query) {
        return List.of("Job: Senior " + query, "Job: Principal " + query);
    }
}
