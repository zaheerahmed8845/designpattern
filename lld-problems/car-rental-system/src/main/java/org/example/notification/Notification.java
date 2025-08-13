package org.example.notification;

import org.example.person.Account;

import java.time.LocalDateTime;

public abstract class Notification {
    private int notificationId;
    private LocalDateTime createdOn;
    private String content;

    public Notification(int notificationId, String content) {
        this.notificationId = notificationId;
        this.content = content;
        this.createdOn = LocalDateTime.now();
    }

    public abstract void sendNotification(Account account);

    public int getNotificationId() {
        return notificationId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getContent() {
        return content;
    }
}
