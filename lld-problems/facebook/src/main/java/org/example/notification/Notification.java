package org.example.notification;

import org.example.person.User;

import java.time.LocalDateTime;

public abstract class Notification {
    private static int SEQ = 1;
    private final String id = "notif-" + (SEQ++);
    private final LocalDateTime createdOn = LocalDateTime.now();
    private final User recipient;
    private final String content;

    protected Notification(User recipient, String content) {
        this.recipient = recipient;
        this.content = content;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + " -> " + recipient.getName() + "] " + content;
    }
}
