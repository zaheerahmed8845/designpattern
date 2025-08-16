package org.example.event;

import org.example.entity.User;

public class ConnectionRequestedEvent implements Event {
    private final User sender;
    private final User recipient;
    private final boolean accepted;

    public ConnectionRequestedEvent(User sender, User recipient, boolean accepted) {
        this.sender = sender;
        this.recipient = recipient;
        this.accepted = accepted;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
