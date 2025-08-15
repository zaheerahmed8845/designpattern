package org.example.state;

import org.example.entity.FriendRequest;

public class PendingState implements FriendRequestState {
    @Override
    public String name() {
        return "Pending";
    }

    @Override
    public void accept(FriendRequest ctx) {
        ctx.setState(new AcceptedState());
    }

    @Override
    public void reject(FriendRequest ctx) {
        ctx.setState(new RejectedState());
    }

    @Override
    public void cancel(FriendRequest ctx) {
        ctx.setState(new CanceledState());
    }
}
