package org.example.decorator;

import org.example.user.User;

public class BlockedUserDecorator extends CapabilityDecorator {
    public BlockedUserDecorator(UserCapability n) {
        super(n);
    }

    @Override
    public boolean canPostQuestion(User u) {
        return false;
    }

    @Override
    public boolean canAnswer(User u) {
        return false;
    }

    @Override
    public boolean canComment(User u) {
        return false;
    }

    @Override
    public boolean canVote(User u) {
        return false;
    }
}
