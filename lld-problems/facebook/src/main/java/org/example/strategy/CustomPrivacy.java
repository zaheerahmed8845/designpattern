package org.example.strategy;

import org.example.observer.Post;
import org.example.person.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomPrivacy implements PrivacyStrategy {
    private final Set<String> allow = new HashSet<>();

    public CustomPrivacy(Collection<User> allowed) {
        for (User u : allowed) allow.add(u.getId());
    }

    @Override
    public boolean canView(User actor, Post post) {
        return actor != null && (actor == post.getOwner() || allow.contains(actor.getId()));
    }

    @Override
    public String name() {
        return "Custom";
    }
}
