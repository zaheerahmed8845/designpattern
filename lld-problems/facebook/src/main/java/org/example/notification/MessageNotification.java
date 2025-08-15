package org.example.notification;

import org.example.entity.Message;
import org.example.person.User;

public class MessageNotification extends Notification {
    private final Message message;

    public MessageNotification(User recipient, String content, Message message) {
        super(recipient, content);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
