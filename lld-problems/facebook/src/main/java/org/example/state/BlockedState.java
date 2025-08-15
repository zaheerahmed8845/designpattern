package org.example.state;

public class BlockedState implements AccountState {
    @Override
    public String name() {
        return "Blocked";
    }

    @Override
    public boolean canPost() {
        return false;
    }

    @Override
    public boolean canSendMessage() {
        return false;
    }
}
