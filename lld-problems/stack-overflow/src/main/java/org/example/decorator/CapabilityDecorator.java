package org.example.decorator;

import org.example.user.User;

public abstract class CapabilityDecorator implements UserCapability {
    protected final UserCapability next;

    protected CapabilityDecorator(UserCapability n) {
        this.next = n;
    }

    public boolean canPostQuestion(User u) {
        return next.canPostQuestion(u);
    }

    public boolean canAnswer(User u) {
        return next.canAnswer(u);
    }

    public boolean canComment(User u) {
        return next.canComment(u);
    }

    public boolean canVote(User u) {
        return next.canVote(u);
    }
}
