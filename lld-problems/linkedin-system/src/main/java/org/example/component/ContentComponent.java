package org.example.component;

import org.example.entity.User;

import java.util.List;

public interface ContentComponent {
    long getId();

    User getAuthor();

    String getText();

    void setText(String newText);

    // extension points for Decorator
    void addReaction(String type);

    void share(User by);

    Comment reply(User author, String text);

    int getReactionCount();

    int getShareCount();

    List<Comment> getComments();
}
