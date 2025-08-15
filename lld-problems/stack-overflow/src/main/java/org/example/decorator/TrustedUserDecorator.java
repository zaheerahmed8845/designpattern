package org.example.decorator;

import org.example.user.User;

public class TrustedUserDecorator extends CapabilityDecorator {
    public TrustedUserDecorator(UserCapability n) {
        super(n);
    }

    @Override
    public boolean canVote(User u) {
        return true;
    } // example: always allow voting
}
