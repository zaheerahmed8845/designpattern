package org.example.search;

import org.example.entity.Question;

import java.util.List;

public interface Search {
    List<Question> searchByTags(String tagName);

    List<Question> searchByUsers(String userName);

    List<Question> searchByWords(String words);
}
