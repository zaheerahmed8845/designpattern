package org.example.state;

import org.example.entity.FriendRequest;

public class CanceledState implements FriendRequestState {
    @Override
    public String name() {
        return "Canceled";
    }

    @Override
    public void accept(FriendRequest ctx) { /* terminal */ }

    @Override
    public void reject(FriendRequest ctx) { /* terminal */ }

    @Override
    public void cancel(FriendRequest ctx) { /* terminal */ }
}
