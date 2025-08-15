package org.example.state;

import org.example.entity.FriendRequest;

public class AcceptedState implements FriendRequestState {
    @Override
    public String name() {
        return "Accepted";
    }

    @Override
    public void accept(FriendRequest ctx) { /* no-op */ }

    @Override
    public void reject(FriendRequest ctx) { /* no-op */ }

    @Override
    public void cancel(FriendRequest ctx) { /* no-op */ }
}
