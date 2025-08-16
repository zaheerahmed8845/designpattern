package org.example.notification.template;

import org.example.account.Member;
import org.example.notification.NotificationMessage;

public class SmsNotification extends Notification {

    @Override
    protected void validate(Member recipient, NotificationMessage message) {
        if (recipient == null || recipient.getPhone() == null || recipient.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Recipient phone is missing");
        }
        if (message == null || message.getBody() == null || message.getBody().isEmpty()) {
            throw new IllegalArgumentException("SMS body is empty");
        }
    }

    @Override
    protected void deliver(Member recipient, String renderedPayload) {
        // Stub: integrate with SMS provider here
        System.out.println("[SMS → " + recipient.getPhone() + "] " + renderedPayload);
    }
}
