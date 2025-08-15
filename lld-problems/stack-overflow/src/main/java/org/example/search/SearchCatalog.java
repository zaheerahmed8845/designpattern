package org.example.search;

import org.example.entity.Question;
import org.example.entity.Tag;

import java.util.*;

public class SearchCatalog implements Search {
    private final Map<Tag, Set<Question>> questionsUsingTags = new HashMap<>();
    private final Map<String, Set<Question>> questionsUsingUsers = new HashMap<>(); // normalized username
    private final Map<String, Set<Question>> questionsUsingWords = new HashMap<>();

    public void indexQuestion(Question q) {
        for (Tag t : q.getTags()) questionsUsingTags.computeIfAbsent(t, k -> new LinkedHashSet<>()).add(q);
        questionsUsingUsers.computeIfAbsent(q.getCreatedBy().getName().toLowerCase(Locale.ROOT), k -> new LinkedHashSet<>()).add(q);
        for (String w : tokenize(q.getTitle() + " " + q.getContent()))
            questionsUsingWords.computeIfAbsent(w, k -> new LinkedHashSet<>()).add(q);
    }

    @Override
    public List<Question> searchByTags(String tagName) {
        return new ArrayList<>(questionsUsingTags.getOrDefault(new Tag(tagName, null), Set.of()));
    }

    @Override
    public List<Question> searchByUsers(String userName) {
        return new ArrayList<>(questionsUsingUsers.getOrDefault(userName.toLowerCase(Locale.ROOT), Set.of()));
    }

    @Override
    public List<Question> searchByWords(String words) {
        Set<Question> result = new LinkedHashSet<>();
        for (String w : tokenize(words)) result.addAll(questionsUsingWords.getOrDefault(w, Set.of()));
        return new ArrayList<>(result);
    }

    private static List<String> tokenize(String text) {
        if (text == null || text.isBlank()) return List.of();
        String[] parts = text.toLowerCase(Locale.ROOT).split("[^a-z0-9]+");
        List<String> tokens = new ArrayList<>();
        for (String p : parts) if (!p.isBlank()) tokens.add(p);
        return tokens;
    }
}
