package org.example.event;

public final class AnswerAddedEvent implements DomainEvent {
    public final long questionId;
    public final long answerId;
    public final long authorId;

    public AnswerAddedEvent(long q, long a, long u) {
        questionId = q;
        answerId = a;
        authorId = u;
    }
}