package org.example.observer;

import org.example.enums.EventType;

public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(EventType type, Object payload);
}
