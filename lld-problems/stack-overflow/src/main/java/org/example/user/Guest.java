package org.example.user;

import org.example.entity.Question;
import org.example.search.Search;
import org.example.util.IdGen;

import java.util.List;

public class Guest {
    public User registerAccount(String name) {
        return new User(IdGen.next(), name, 1);
    }

    public List<Question> searchQuestion(Search search, String query) {
        return search.searchByWords(query);
    }

    public void viewQuestion(Question q) {
        q.incrementViewCount();
    }
}
