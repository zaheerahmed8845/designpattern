package org.example.event;

import org.example.component.Comment;
import org.example.component.Post;

public class CommentAddedEvent implements Event {
    private final Post post;
    private final Comment comment;

    public CommentAddedEvent(Post post, Comment comment) {
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
