package org.example.notification.decorator;

import org.example.account.Member;
import org.example.notification.NotificationMessage;
import org.example.notification.template.Notification;

public class LoggingNotificationDecorator extends NotificationDecorator {

    public LoggingNotificationDecorator(Notification delegate) {
        super(delegate);
    }

    @Override
    public void send(Member recipient, NotificationMessage message) {
        long start = System.currentTimeMillis();
        System.out.println("[Notify][BEGIN] channel=" + delegate.getClass().getSimpleName()
                + " to=" + (recipient != null ? recipient.getId() : "null"));
        try {
            super.send(recipient, message);
            System.out.println("[Notify][OK]   elapsedMs=" + (System.currentTimeMillis() - start));
        } catch (RuntimeException ex) {
            System.out.println("[Notify][FAIL] elapsedMs=" + (System.currentTimeMillis() - start)
                    + " err=" + ex.getMessage());
            throw ex;
        }
    }
}
