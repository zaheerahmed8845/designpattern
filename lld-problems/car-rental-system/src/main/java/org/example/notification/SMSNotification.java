package org.example.notification;

import org.example.person.Account;

public class SMSNotification extends Notification {
    public SMSNotification(int notificationId, String content) {
        super(notificationId, content);
    }

    @Override
    public void sendNotification(Account account) { /* stub */ }
}
