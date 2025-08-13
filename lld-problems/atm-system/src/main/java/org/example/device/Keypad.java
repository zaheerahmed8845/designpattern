package org.example.device;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Keypad implements Device {
    private final Queue<String> scripted = new ArrayDeque<>();
    private final Scanner scanner = new Scanner(System.in);

    public void enqueue(String v) {
        scripted.add(v);
    }

    public String getInput() {
        if (!scripted.isEmpty()) return scripted.poll();
        return scanner.nextLine();
    }

    @Override
    public void selfTest() { /* ok */ }
}
