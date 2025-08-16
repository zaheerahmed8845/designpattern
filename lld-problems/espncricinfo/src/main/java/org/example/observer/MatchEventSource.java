package org.example.observer;

public interface MatchEventSource {
    void register(MatchObserver obs);

    void unregister(MatchObserver obs);

    void notifyAllObservers(MatchEvent event);
}
