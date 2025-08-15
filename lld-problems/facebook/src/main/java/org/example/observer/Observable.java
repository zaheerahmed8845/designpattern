package org.example.observer;

import org.example.notification.Notification;

public interface Observable {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(Notification n);
}
