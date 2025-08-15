package org.example.search;

import org.example.observer.Post;
import org.example.person.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchCatalog {
    private static final SearchCatalog INSTANCE = new SearchCatalog();

    public static SearchCatalog getInstance() {
        return INSTANCE;
    }

    private final Map<String, User> usersByName = new HashMap<>();
    private final List<Post> posts = new ArrayList<>();

    private SearchCatalog() {
    }

    public void indexUser(User u) {
        usersByName.put(u.getName().toLowerCase(), u);
    }

    public void indexPost(Post p) {
        posts.add(p);
    }

    public List<User> searchUsers(String q) {
        String k = q.toLowerCase();
        return usersByName.entrySet().stream()
                .filter(e -> e.getKey().contains(k))
                .map(Map.Entry::getValue).toList();
    }

    public List<Post> searchPostsVisibleTo(String keyword, User viewer) {
        String k = keyword.toLowerCase();
        return posts.stream()
                .filter(p -> p.getContent().toLowerCase().contains(k))
                .filter(p -> p.canView(viewer))
                .collect(Collectors.toList());
    }
}
