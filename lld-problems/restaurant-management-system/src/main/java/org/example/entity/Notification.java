package org.example.entity;

import java.time.Instant;

public abstract class Notification {
    protected String notificationId;
    protected Instant createdOn = Instant.now();
    protected String content;

    public abstract void sendReminderNotification();
}
