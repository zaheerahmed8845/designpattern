package org.example.device;

public class Printer implements Device {
    public boolean printReceipt(String text) {
        System.out.println("[RECEIPT] " + text);
        return true;
    }

    @Override
    public void selfTest() { /* ok */ }
}
