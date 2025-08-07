package org.example.entity.panel;

import org.example.entity.button.HallButton;
import org.example.enums.Direction;

public class HallPanel {

    private final HallButton up;
    private final HallButton down;

    public HallPanel() {
        this.up = new HallButton(Direction.UP);
        this.down = new HallButton(Direction.DOWN);
    }

    public HallButton getUpButton() {
        return up;
    }

    public HallButton getDownButton() {
        return down;
    }
}
