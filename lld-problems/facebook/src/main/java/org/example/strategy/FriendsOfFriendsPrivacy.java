package org.example.strategy;

import org.example.observer.Post;
import org.example.person.User;

public class FriendsOfFriendsPrivacy implements PrivacyStrategy {
    @Override
    public boolean canView(User actor, Post post) {
        if (actor == null) return false;
        if (post.getOwner() == actor || post.getOwner().isFriend(actor)) return true;
        for (User f : post.getOwner().getFriends()) {
            if (f.isFriend(actor)) return true;
        }
        return false;
    }

    @Override
    public String name() {
        return "FriendsOfFriends";
    }
}
