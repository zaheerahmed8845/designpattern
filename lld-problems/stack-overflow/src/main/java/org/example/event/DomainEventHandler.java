package org.example.event;

public interface DomainEventHandler<T extends DomainEvent> {
    void handle(T event);
}
