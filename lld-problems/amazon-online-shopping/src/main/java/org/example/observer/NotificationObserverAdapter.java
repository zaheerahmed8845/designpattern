package org.example.observer;

import org.example.entity.Order;
import org.example.notification.Notification;

/**
 * Bridges the diagram's Notification to Observer callback.
 */
public class NotificationObserverAdapter implements OrderObserver {
    private final Notification notification;

    public NotificationObserverAdapter(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void onOrderStatusChanged(Order order) {
        notification.content = "Order " + order.getOrderNumber() + " is now " + order.getStatus();
        notification.sendNotification();
    }
}
