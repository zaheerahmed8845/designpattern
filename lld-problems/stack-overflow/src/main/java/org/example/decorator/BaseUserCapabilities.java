package org.example.decorator;

import org.example.enums.UserStatus;
import org.example.user.User;

public class BaseUserCapabilities implements UserCapability {
    public boolean canPostQuestion(User u) {
        return u.getStatus() == UserStatus.ACTIVE;
    }

    public boolean canAnswer(User u) {
        return u.getStatus() == UserStatus.ACTIVE;
    }

    public boolean canComment(User u) {
        return u.getStatus() == UserStatus.ACTIVE;
    }

    public boolean canVote(User u) {
        return u.getStatus() == UserStatus.ACTIVE;
    }
}
