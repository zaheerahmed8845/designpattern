package org.example.notification;

import org.example.entity.Account;

public class SmsNotification extends Notification {
    public String number;

    public SmsNotification(String content, String number) {
        this.content = content;
        this.number = number;
    }

    @Override
    protected boolean deliver(Account account) {
        System.out.println("[SMS to " + number + "] " + content);
        return true;
    }
}
