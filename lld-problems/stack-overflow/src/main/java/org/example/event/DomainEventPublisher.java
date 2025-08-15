package org.example.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainEventPublisher {
    private final Map<Class<?>, List<DomainEventHandler<?>>> subs = new HashMap<>();

    public synchronized <T extends DomainEvent> void subscribe(Class<T> type, DomainEventHandler<T> h) {
        subs.computeIfAbsent(type, k -> new ArrayList<>()).add(h);
    }

    @SuppressWarnings("unchecked")
    public void publish(DomainEvent e) {
        var list = subs.getOrDefault(e.getClass(), List.of());
        for (var h : list) ((DomainEventHandler<DomainEvent>) h).handle(e);
    }
}
