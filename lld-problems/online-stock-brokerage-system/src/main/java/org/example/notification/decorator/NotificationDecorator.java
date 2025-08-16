package org.example.notification.decorator;

import org.example.account.Member;
import org.example.notification.NotificationMessage;
import org.example.notification.template.Notification;

import java.util.Objects;

public abstract class NotificationDecorator extends Notification {
    protected final Notification delegate;

    public NotificationDecorator(Notification delegate) {
        this.delegate = Objects.requireNonNull(delegate);
    }

    @Override
    public void send(Member recipient, NotificationMessage message) {
        // You can intercept before/after if needed; by default just delegate
        delegate.send(recipient, message);
    }

    @Override
    protected void validate(Member recipient, NotificationMessage message) {
        // Delegate validation
        // (We don't call super since base Notification has no concrete validation)
        // The delegate's validate is invoked when delegate.send is called.
    }

    @Override
    protected void deliver(Member recipient, String renderedPayload) {
        // Never called directly because we delegate send()
    }
}
