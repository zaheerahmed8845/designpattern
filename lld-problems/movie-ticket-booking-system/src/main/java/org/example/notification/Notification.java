package org.example.notification;

import org.example.person.Person;

import java.time.OffsetDateTime;

public abstract class Notification {
    private int notificationID;
    private OffsetDateTime createdOn = OffsetDateTime.now();
    private String content;

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int v) {
        notificationID = v;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String v) {
        content = v;
    }

    public abstract void sendNotification(Person person);
}
