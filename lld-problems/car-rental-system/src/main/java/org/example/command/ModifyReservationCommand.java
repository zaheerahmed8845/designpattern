package org.example.command;

import org.example.entity.ReservationManager;

import java.time.LocalDateTime;

public class ModifyReservationCommand implements Command {
    private final int reservationId;
    private final LocalDateTime newStart;
    private final LocalDateTime newEnd;

    public ModifyReservationCommand(int reservationId, LocalDateTime newStart, LocalDateTime newEnd) {
        this.reservationId = reservationId;
        this.newStart = newStart;
        this.newEnd = newEnd;
    }

    @Override
    public boolean execute() {
        return ReservationManager.getInstance().get(reservationId).map(r -> {
            try {
                java.lang.reflect.Field f1 = r.getClass().getDeclaredField("startDate");
                java.lang.reflect.Field f2 = r.getClass().getDeclaredField("dueDate");
                f1.setAccessible(true);
                f2.setAccessible(true);
                f1.set(r, newStart);
                f2.set(r, newEnd);
                return true;
            } catch (Exception e) {
                return false;
            }
        }).orElse(false);
    }
}
