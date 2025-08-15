package org.example.entity;

import org.example.user.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class Notification {
    private final long notificationId;
    private User account;
    private final String content;
    private final LocalDateTime createdOn = LocalDateTime.now();

    public Notification(long id, User account, String content) {
        this.notificationId = id;
        this.account = Objects.requireNonNull(account);
        this.content = Objects.requireNonNull(content);
    }

    public long getNotificationId() {
        return notificationId;
    }

    public User getAccount() {
        return account;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void sendNotification(User account) {
        this.account = Objects.requireNonNull(account); /* stub */
    }
}
