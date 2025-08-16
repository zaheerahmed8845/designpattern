package org.example.entity;

import java.time.LocalDateTime;

public class Notification {
    private int notificationId;
    private LocalDateTime createdOn = LocalDateTime.now();
    private String content;

    public Notification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
