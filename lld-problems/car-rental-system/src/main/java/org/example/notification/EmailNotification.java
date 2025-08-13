package org.example.notification;

import org.example.person.Account;

public class EmailNotification extends Notification {
    public EmailNotification(int notificationId, String content) {
        super(notificationId, content);
    }

    @Override
    public void sendNotification(Account account) { /* stub */ }
}
