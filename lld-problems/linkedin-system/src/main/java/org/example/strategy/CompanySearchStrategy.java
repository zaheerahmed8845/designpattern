package org.example.strategy;

import java.util.List;

public class CompanySearchStrategy implements SearchStrategy {
    @Override
    public List<String> search(String query) {
        return List.of("Company: " + query + " Labs", "Company: " + query + " Systems");
    }
}
