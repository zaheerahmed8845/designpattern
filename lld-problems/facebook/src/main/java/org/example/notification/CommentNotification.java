package org.example.notification;

import org.example.entity.Comment;
import org.example.observer.Post;
import org.example.person.User;

public class CommentNotification extends Notification {
    private final Post post;
    private final Comment comment;

    public CommentNotification(User recipient, String content, Post post, Comment comment) {
        super(recipient, content);
        this.post = post;
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public Comment getComment() {
        return comment;
    }
}
