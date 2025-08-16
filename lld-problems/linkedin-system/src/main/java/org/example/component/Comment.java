package org.example.component;

import org.example.entity.User;
import org.example.event.CommentAddedEvent;
import org.example.event.DomainEventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Comment implements ContentComponent {
    private static final AtomicLong ID_GEN = new AtomicLong(1);

    private final long commentId;
    private final Post post;
    private final User author;
    private String text;
    private int totalReacts;
    private int totalShares;
    private List<Comment> replies = new ArrayList<>();

    public Comment(Post post, User author, String text) {
        this.commentId = ID_GEN.getAndIncrement();
        this.post = post;
        this.author = author;
        this.text = text;
        DomainEventBus.getInstance().publish(new CommentAddedEvent(post, this));
    }

    @Override
    public long getId() {
        return commentId;
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
        Comment c = new Comment(this.post, author, text);
        replies.add(c);
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
        return replies;
    }

    @Override
    public String toString() {
        return "Comment#" + commentId + " by " + author.getName() + ": " + text;
    }
}
