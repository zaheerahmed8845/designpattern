package org.example.state;

public class ActiveState implements AccountState {
    @Override
    public String name() {
        return "Active";
    }

    @Override
    public boolean canPost() {
        return true;
    }

    @Override
    public boolean canSendMessage() {
        return true;
    }
}
