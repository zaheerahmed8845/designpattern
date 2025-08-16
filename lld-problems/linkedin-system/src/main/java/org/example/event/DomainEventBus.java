package org.example.event;

import java.util.ArrayList;
import java.util.List;

public class DomainEventBus {
    private static final DomainEventBus INSTANCE = new DomainEventBus();
    private final List<EventListener> listeners = new ArrayList<>();

    private DomainEventBus() {
    }

    public static DomainEventBus getInstance() {
        return INSTANCE;
    }

    public void register(EventListener l) {
        listeners.add(l);
    }

    public void unregister(EventListener l) {
        listeners.remove(l);
    }

    public void publish(Event e) {
        for (EventListener l : List.copyOf(listeners)) {
            try {
                l.onEvent(e);
            } catch (RuntimeException ignored) {
            }
        }
    }
}
