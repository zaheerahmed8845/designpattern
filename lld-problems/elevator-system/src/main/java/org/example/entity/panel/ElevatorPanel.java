package org.example.entity.panel;

import org.example.entity.button.ElevatorButton;
import org.example.entity.button.EmergencyButton;

import java.util.ArrayList;
import java.util.List;

public class ElevatorPanel {
    List<ElevatorButton> floorButtons;
    ElevatorButton openButton;
    ElevatorButton closeButton;
    EmergencyButton emergencyButton;

    public ElevatorPanel(int numFloors) {
        floorButtons = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) floorButtons.add(new ElevatorButton(i));
        openButton = new ElevatorButton(-1); // Open and Close buttons could be separated
        closeButton = new ElevatorButton(-2);
        emergencyButton = new EmergencyButton();
    }

    public void enterEmergency() {
        emergencyButton.pressDown();
    }

    public void exitEmergency() {
        emergencyButton.reset();
    }
}
