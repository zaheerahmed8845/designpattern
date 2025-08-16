package org.example.notification;

import org.example.entity.Account;
import org.example.enums.AccountStatus;

import java.time.LocalDateTime;

public abstract class Notification {
    public String notificationId = "N-" + System.nanoTime();
    public LocalDateTime createdOn = LocalDateTime.now();
    public String content;

    public final boolean sendNotification(Account account) {
        if (account == null || account.status != AccountStatus.ACTIVE) return false;
        preSend();
        boolean ok = deliver(account);
        postSend(ok);
        return ok;
    }

    protected void preSend() { /* logging, formatting, etc */ }

    protected abstract boolean deliver(Account account); // implemented by subclasses

    protected void postSend(boolean ok) {
        System.out.println("Notification " + notificationId + " delivered=" + ok);
    }
}
