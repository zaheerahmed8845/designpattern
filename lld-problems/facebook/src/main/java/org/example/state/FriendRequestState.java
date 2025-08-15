package org.example.state;

import org.example.entity.FriendRequest;

public interface FriendRequestState {
    String name();

    void accept(FriendRequest ctx);

    void reject(FriendRequest ctx);

    void cancel(FriendRequest ctx);
}
