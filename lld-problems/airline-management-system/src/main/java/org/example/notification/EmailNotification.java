package org.example.notification;

import org.example.entity.Account;

public class EmailNotification extends Notification {
    public String email;

    public EmailNotification(String content, String email) {
        this.content = content;
        this.email = email;
    }

    @Override
    protected boolean deliver(Account account) {
        System.out.println("[EMAIL to " + email + "] " + content);
        return true;
    }
}
