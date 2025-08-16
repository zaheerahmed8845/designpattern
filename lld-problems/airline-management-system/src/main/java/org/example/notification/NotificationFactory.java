package org.example.notification;

import org.example.enums.NotificationType;
import org.example.person.Person;

public class NotificationFactory {
    public static Notification create(NotificationType type, String content, Person person) {
        switch (type) {
            case EMAIL:
                return new EmailNotification(content, person.email);
            case SMS:
                return new SmsNotification(content, person.phone);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
