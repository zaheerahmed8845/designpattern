package org.example.event;

public final class QuestionClosedEvent implements DomainEvent {
    public final long questionId;
    public final String reason;

    public QuestionClosedEvent(long id, String r) {
        questionId = id;
        reason = r;
    }
}