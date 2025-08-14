package org.example.notification;

import java.time.Instant;

public abstract class Notification {
    protected String notificationID;
    protected Instant createdOn = Instant.now();
    public String content;

    public abstract void sendNotification();
}
