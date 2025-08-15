package org.example.state;

public class DisabledState implements AccountState {
    @Override
    public String name() {
        return "Disabled";
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
