package org.example.entity;

import org.example.enums.NotificationType;
import org.example.notification.NotificationFactory;
import org.example.person.User;

import java.util.List;

public class Message {
    private static int SEQ = 1;
    private final String id = "msg-" + (SEQ++);
    private final User sender;
    private final List<User> recipients;
    private final String body;

    public Message(User sender, List<User> recipients, String body) {
        this.sender = sender;
        this.recipients = recipients;
        this.body = body;
    }

    public void send() {
        for (User r : recipients) {
            r.update(NotificationFactory.create(NotificationType.MESSAGE, r,
                    sender.getName() + " messaged: " + body, null, null, this));
        }
    }

    @Override
    public String toString() {
        return "Message(" + sender.getName() + " -> " + recipients.size() + ")";
    }
}
