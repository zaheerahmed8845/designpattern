package org.example.component;

import org.example.entity.User;
import org.example.event.DomainEventBus;
import org.example.event.PostCreatedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Post implements ContentComponent {
    private static final AtomicLong ID_GEN = new AtomicLong(1);

    private final long postId;
    private final User author;
    private String text;
    private List<String> media = new ArrayList<>();
    private int totalReacts;
    private int totalShares;
    private List<Comment> comments = new ArrayList<>();

    public Post(User author, String text) {
        this.postId = ID_GEN.getAndIncrement();
        this.author = author;
        this.text = text;
        // Observer: emit creation event
        DomainEventBus.getInstance().publish(new PostCreatedEvent(this));
    }

    @Override
    public long getId() {
        return postId;
    }

    @Override
    public User getAuthor() {
        return author;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String newText) {
        this.text = newText;
    }

    @Override
    public void addReaction(String type) {
        totalReacts++;
    }

    @Override
    public void share(User by) {
        totalShares++;
    }

    @Override
    public Comment reply(User author, String text) {
        Comment c = new Comment(this, author, text);
        comments.add(c);
        return c;
    }

    @Override
    public int getReactionCount() {
        return totalReacts;
    }

    @Override
    public int getShareCount() {
        return totalShares;
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Post#" + postId + " by " + author.getName() + ": " + text;
    }
}
