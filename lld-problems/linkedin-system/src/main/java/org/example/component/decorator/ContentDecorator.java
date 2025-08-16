package org.example.component.decorator;

import org.example.component.Comment;
import org.example.component.ContentComponent;
import org.example.entity.User;

import java.util.List;

public abstract class ContentDecorator implements ContentComponent {
    protected final ContentComponent inner;

    protected ContentDecorator(ContentComponent inner) {
        this.inner = inner;
    }

    @Override
    public long getId() {
        return inner.getId();
    }

    @Override
    public User getAuthor() {
        return inner.getAuthor();
    }

    @Override
    public String getText() {
        return inner.getText();
    }

    @Override
    public void setText(String newText) {
        inner.setText(newText);
    }

    @Override
    public void addReaction(String type) {
        inner.addReaction(type);
    }

    @Override
    public void share(User by) {
        inner.share(by);
    }

    @Override
    public Comment reply(User author, String text) {
        return inner.reply(author, text);
    }

    @Override
    public int getReactionCount() {
        return inner.getReactionCount();
    }

    @Override
    public int getShareCount() {
        return inner.getShareCount();
    }

    @Override
    public List<Comment> getComments() {
        return inner.getComments();
    }
}
