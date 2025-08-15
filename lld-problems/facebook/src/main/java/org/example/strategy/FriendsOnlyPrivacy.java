package org.example.strategy;

import org.example.observer.Post;
import org.example.person.User;

public class FriendsOnlyPrivacy implements PrivacyStrategy {
    @Override
    public boolean canView(User actor, Post post) {
        if (actor == null) return false;
        return post.getOwner() == actor || post.getOwner().isFriend(actor);
    }

    @Override
    public String name() {
        return "FriendsOnly";
    }
}
