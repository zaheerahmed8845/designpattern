package org.example.search;

import org.example.entity.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> search(String query);
}

