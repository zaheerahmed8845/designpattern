package org.example.entity;

import org.example.person.User;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Comment {
    private static int SEQ = 1;
    private final String id = "c-" + (SEQ++);
    private final User owner;
    private final String text;
    private final LocalDateTime createdOn = LocalDateTime.now();
    private final Set<User> likes = new HashSet<>();

    public Comment(User owner, String text) {
        this.owner = owner;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public void addLike(User u) {
        likes.add(u);
    }
}
