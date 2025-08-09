package org.example.observer;

public class DisplayObserver implements MachineObserver {
    @Override
    public void onMessage(String message) {
        System.out.println("[DISPLAY] " + message);
    }

    @Override
    public void onStateChanged(String from, String to) {
        System.out.println("[DISPLAY] State: " + from + " -> " + to);
    }
}
