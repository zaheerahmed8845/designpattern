package org.example.state;

public interface AccountState {
    String name();

    boolean canPost();

    boolean canSendMessage();
}
