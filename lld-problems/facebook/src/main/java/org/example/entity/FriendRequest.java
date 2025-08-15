package org.example.entity;

import org.example.enums.NotificationType;
import org.example.notification.NotificationFactory;
import org.example.person.User;
import org.example.state.AcceptedState;
import org.example.state.FriendRequestState;
import org.example.state.PendingState;

public class FriendRequest {
    private final User from;
    private final User to;
    private FriendRequestState state = new PendingState();

    public FriendRequest(User from, User to) {
        this.from = from;
        this.to = to;
    }

    public String getStatus() {
        return state.name();
    }

    public void setState(FriendRequestState s) {
        this.state = s;
    }

    public void accept() {
        state.accept(this);
        if (state instanceof AcceptedState) {
            from.addFriend(to);
            to.addFriend(from);
            to.update(NotificationFactory.create(NotificationType.POST, to,
                    from.getName() + " is now your friend", null, null, null));
        }
    }

    public void reject() {
        state.reject(this);
    }

    public void cancel() {
        state.cancel(this);
    }
}
