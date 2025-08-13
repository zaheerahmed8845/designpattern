package org.example.device;

public class Screen implements Device {
    public boolean showMessage(String message) {
        System.out.println("[SCREEN] " + message);
        return true;
    }

    @Override
    public void selfTest() { /* ok */ }
}
