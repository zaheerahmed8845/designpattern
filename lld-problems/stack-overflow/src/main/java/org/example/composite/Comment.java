package org.example.composite;

// =============================================================
// COMPOSITE (nested comments)
// =============================================================

import org.example.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Comment {
    private final long id;
    private User postedBy;
    private final String content;
    private int voteCount;
    private int upvotes;
    private final LocalDateTime creationDate = LocalDateTime.now();
    private final List<Comment> children = new ArrayList<>();

    public Comment(long id, User postedBy, String content) {
        this.id = id;
        this.postedBy = postedBy;
        this.content = Objects.requireNonNull(content);
    }

    public long getId() {
        return id;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Comment> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = Objects.requireNonNull(postedBy);
    }

    public void addChild(Comment c) {
        children.add(Objects.requireNonNull(c));
    }

    public void upvote() {
        upvotes++;
        voteCount++;
    }

    public void downvote() {
        voteCount++;
    }
}
