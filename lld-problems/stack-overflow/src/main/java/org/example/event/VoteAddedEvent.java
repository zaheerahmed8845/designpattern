package org.example.event;

public final class VoteAddedEvent implements DomainEvent {
    public final long postId;
    public final boolean up;

    public VoteAddedEvent(long p, boolean u) {
        postId = p;
        up = u;
    }
}

