package org.example.notification;

import org.example.enums.NotificationType;

public class NotificationFactory {
    public static Notifier create(NotificationType type) {
        return switch (type) {
            case SMS -> new SMSNotifier();
            case EMAIL -> new EmailNotifier();
        };
    }
}
