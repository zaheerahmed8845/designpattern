package org.example.observer;

import org.example.entity.RoomBookingEvent;
import org.example.enums.NotificationType;
import org.example.notification.NotificationFactory;
import org.example.notification.Notifier;

public class FactoryBackedNotifierObserver implements Observer {
    private final NotificationType type;

    public FactoryBackedNotifierObserver(NotificationType type) {
        this.type = type;
    }

    @Override
    public void update(RoomBookingEvent event) {
        Notifier notifier = NotificationFactory.create(type);
        notifier.notify(event.guest, event.message);
    }
}
