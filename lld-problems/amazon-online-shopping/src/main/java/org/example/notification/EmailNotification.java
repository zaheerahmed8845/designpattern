package org.example.notification;

public class EmailNotification extends Notification {
    private final String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void sendNotification() {
        System.out.printf("[Email->%s] %s%n", email, content);
    }

    public void setContent(String content) {
        this.content = content;
    }
}
