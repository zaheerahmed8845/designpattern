package org.example.strategy;

import org.example.observer.Post;
import org.example.person.User;

public interface PrivacyStrategy {
    boolean canView(User actor, Post post);

    String name();
}
