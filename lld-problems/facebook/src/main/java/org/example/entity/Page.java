package org.example.entity;

import org.example.enums.NotificationType;
import org.example.notification.NotificationFactory;
import org.example.observer.Post;
import org.example.person.User;
import org.example.search.SearchCatalog;
import org.example.strategy.PrivacyStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Page {
    private static int SEQ = 1;
    private final String id = "page-" + (SEQ++);
    private final String title;
    private final Set<User> followers = new HashSet<>();
    private final List<Post> posts = new ArrayList<>();

    public Page(String title) {
        this.title = title;
    }

    public void addFollower(User u) {
        followers.add(u);
    }

    public void removeFollower(User u) {
        followers.remove(u);
    }

    public Post createPost(User actor, String content, PrivacyStrategy privacy) {
        Post p = new Post(actor, "[Page: " + title + "] " + content, privacy);
        posts.add(p);
        for (User f : followers) {
            if (p.canView(f)) {
                f.update(NotificationFactory.create(NotificationType.POST, f,
                        "New page post from " + actor.getName() + ": " + content, p, null, null));
                p.addObserver(f);
            }
        }
        SearchCatalog.getInstance().indexPost(p);
        return p;
    }
}
