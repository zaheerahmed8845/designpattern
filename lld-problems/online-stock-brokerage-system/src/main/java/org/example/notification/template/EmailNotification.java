package org.example.notification.template;

import org.example.account.Member;
import org.example.notification.NotificationMessage;

public class EmailNotification extends Notification {

    @Override
    protected void validate(Member recipient, NotificationMessage message) {
        if (recipient == null || recipient.getEmail() == null || recipient.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Recipient email is missing");
        }
        if (message == null || (message.getSubject() == null && message.getBody() == null)) {
            throw new IllegalArgumentException("Email message is empty");
        }
    }

    @Override
    protected void deliver(Member recipient, String renderedPayload) {
        // Stub: integrate with SMTP provider here
        System.out.println("[EMAIL → " + recipient.getEmail() + "] " + renderedPayload);
    }
}
