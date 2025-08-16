package org.example.command;

import org.example.account.Member;
import org.example.notification.NotificationMessage;
import org.example.notification.template.Notification;

import java.util.Objects;

public class SendNotificationCommand implements Command {
    private final Notification notifier;
    private final Member recipient;
    private final NotificationMessage message;

    public SendNotificationCommand(Notification notifier,
                                   Member recipient,
                                   NotificationMessage message) {
        this.notifier = Objects.requireNonNull(notifier);
        this.recipient = Objects.requireNonNull(recipient);
        this.message = Objects.requireNonNull(message);
    }

    @Override
    public void execute() {
        notifier.send(recipient, message);
    }
}
