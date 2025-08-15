package org.example.notification;

import org.example.observer.Post;
import org.example.person.User;

public class PostNotification extends Notification {
    private final Post post;

    public PostNotification(User recipient, String content, Post post) {
        super(recipient, content);
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
