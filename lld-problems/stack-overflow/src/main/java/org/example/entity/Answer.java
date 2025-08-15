package org.example.entity;

import org.example.composite.Comment;
import org.example.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Answer {
    private final long id;
    private String content;
    private User postedBy;
    private final List<Comment> comments = new ArrayList<>();
    private int flagCount;
    private int downvotes;
    private int upvotes;
    private final LocalDateTime creationDate = LocalDateTime.now();
    private boolean isAccepted;
    private boolean deleted;

    public Answer(long id, String content, User postedBy) {
        this.id = id;
        this.content = Objects.requireNonNull(content);
        this.postedBy = postedBy;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setPostedBy(User u) {
        this.postedBy = Objects.requireNonNull(u);
    }

    public void setAccepted(boolean a) {
        isAccepted = a;
    }

    public void addComment(Comment c) {
        comments.add(Objects.requireNonNull(c));
    }

    public void addFlag(User flagger, String reason) {
        flagCount++;
    }

    public void markDeleted() {
        deleted = true;
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        downvotes++;
    }
}
