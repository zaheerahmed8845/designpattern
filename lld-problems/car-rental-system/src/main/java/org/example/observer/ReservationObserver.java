package org.example.observer;

import org.example.entity.VehicleReservation;

public interface ReservationObserver {
    void onReservationUpdated(VehicleReservation reservation);
}
