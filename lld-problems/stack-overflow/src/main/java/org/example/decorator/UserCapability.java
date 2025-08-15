package org.example.decorator;

import org.example.user.User;

public interface UserCapability {
    boolean canPostQuestion(User u);

    boolean canAnswer(User u);

    boolean canComment(User u);

    boolean canVote(User u);
}
