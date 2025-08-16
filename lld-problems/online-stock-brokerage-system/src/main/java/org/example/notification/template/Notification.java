package org.example.notification.template;

import org.example.account.Member;
import org.example.notification.NotificationMessage;

public abstract class Notification {

    // Template method: final algorithm
    public void send(Member recipient, NotificationMessage message) {
        validate(recipient, message);
        String rendered = render(message);
        deliver(recipient, rendered);
        afterSend(recipient, message); // hook (optional override)
    }

    // Steps to be implemented/overridden by subclasses
    protected abstract void validate(Member recipient, NotificationMessage message);

    // Default rendering can be shared; subclasses may override if needed
    protected String render(NotificationMessage message) {
        String subject = message.getSubject() == null ? "" : message.getSubject();
        String body = message.getBody() == null ? "" : message.getBody();
        return subject.isEmpty() ? body : ("[" + subject + "] " + body);
    }

    // Channel-specific delivery
    protected abstract void deliver(Member recipient, String renderedPayload);

    // Optional hook for auditing/metrics
    protected void afterSend(Member recipient, NotificationMessage message) {
        // no-op by default
    }
}
