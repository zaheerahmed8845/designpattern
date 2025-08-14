package org.example.notification;

public class SmsNotification extends Notification {
    private final String phone;

    public SmsNotification(String phone) {
        this.phone = phone;
    }

    @Override
    public void sendNotification() {
        System.out.printf("[SMS->%s] %s%n", phone, content);
    }

    public void setContent(String content) {
        this.content = content;
    }
}
