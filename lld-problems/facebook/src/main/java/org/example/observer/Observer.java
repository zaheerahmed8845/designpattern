package org.example.observer;

import org.example.notification.Notification;

public interface Observer {
    void update(Notification notification);
}
