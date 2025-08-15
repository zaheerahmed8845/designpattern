package org.example.strategy;

import org.example.observer.Post;
import org.example.person.User;

public class PublicPrivacy implements PrivacyStrategy {
    @Override
    public boolean canView(User actor, Post post) {
        return true;
    }

    @Override
    public String name() {
        return "Public";
    }
}
