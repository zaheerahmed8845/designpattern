package org.example.entity.button;

public abstract class Button {
    protected boolean pressed;

    public void pressDown() {
        pressed = true;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void reset() {
        pressed = false;
    }
}
