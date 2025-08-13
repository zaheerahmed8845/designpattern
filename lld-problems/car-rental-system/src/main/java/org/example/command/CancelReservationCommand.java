package org.example.command;

import org.example.entity.ReservationManager;
import org.example.enums.ReservationStatus;

public class CancelReservationCommand implements Command {
    private final int reservationId;

    public CancelReservationCommand(int reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public boolean execute() {
        return ReservationManager.getInstance().changeStatus(reservationId, ReservationStatus.Canceled);
    }
}
