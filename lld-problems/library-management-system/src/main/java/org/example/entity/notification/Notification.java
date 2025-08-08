package org.example.entity.notification;

import java.time.LocalDateTime;

public abstract class Notification {
    private String notificationId;
    private LocalDateTime created;
    private String content;

    public boolean sendNotification() {
        return true;
    }
}
