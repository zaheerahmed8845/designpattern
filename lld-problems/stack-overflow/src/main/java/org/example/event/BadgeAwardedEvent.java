package org.example.event;

public final class BadgeAwardedEvent implements DomainEvent {
    public final long userId;
    public final String badge;

    public BadgeAwardedEvent(long u, String b) {
        userId = u;
        badge = b;
    }
}