package org.example.observer;

public interface MachineObserver {
    default void onInventoryChanged(int rack, int qty) {
    }

    default void onStateChanged(String from, String to) {
    }

    default void onFault(String message) {
    }

    default void onMessage(String message) {
    }
}
