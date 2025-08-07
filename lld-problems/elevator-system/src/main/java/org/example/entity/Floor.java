package org.example.entity;

import org.example.entity.panel.HallPanel;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int floorNumber;
    private final HallPanel panel;
    private final List<Display> displays;

    public Floor(int number) {
        this.floorNumber = number;
        this.panel = new HallPanel();
        this.displays = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public HallPanel getPanel() {
        return panel;
    }

    public List<Display> getDisplay() {
        return displays;
    }
}
