package org.example.event;

public final class CommentAddedEvent implements DomainEvent {
    public final long parentId;
    public final boolean onAnswer;
    public final long commentId;
    public final long authorId;

    public CommentAddedEvent(long parentId, boolean onAnswer, long commentId, long authorId) {
        this.parentId = parentId;
        this.onAnswer = onAnswer;
        this.commentId = commentId;
        this.authorId = authorId;
    }
}