package org.example.entity;

import org.example.enums.ConnectionInviteStatus;
import org.example.event.ConnectionRequestedEvent;
import org.example.event.DomainEventBus;

import java.time.LocalDateTime;

public class ConnectionInvitation {
    private User sender;
    private User recipient;
    private LocalDateTime dateCreated = LocalDateTime.now();
    private ConnectionInviteStatus status = ConnectionInviteStatus.PENDING;

    public ConnectionInvitation(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    public boolean acceptConnection() {
        if (status != ConnectionInviteStatus.PENDING) return false;
        status = ConnectionInviteStatus.ACCEPTED;
        DomainEventBus.getInstance().publish(new ConnectionRequestedEvent(sender, recipient, true));
        return true;
    }

    public boolean ignoreConnection() {
        if (status != ConnectionInviteStatus.PENDING) return false;
        status = ConnectionInviteStatus.IGNORED;
        DomainEventBus.getInstance().publish(new ConnectionRequestedEvent(sender, recipient, false));
        return true;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }
}
