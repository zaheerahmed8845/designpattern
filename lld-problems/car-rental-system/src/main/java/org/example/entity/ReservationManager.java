package org.example.entity;

import org.example.enums.ReservationStatus;
import org.example.observer.ReservationObserver;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationManager {
    private static volatile ReservationManager INSTANCE;

    public static ReservationManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ReservationManager.class) {
                if (INSTANCE == null) INSTANCE = new ReservationManager();
            }
        }
        return INSTANCE;
    }

    private final Map<Integer, VehicleReservation> reservations = new ConcurrentHashMap<>();
    private final List<ReservationObserver> observers = Collections.synchronizedList(new ArrayList<>());

    private ReservationManager() {
    }

    public void registerObserver(ReservationObserver obs) {
        observers.add(obs);
    }

    public void unregisterObserver(ReservationObserver obs) {
        observers.remove(obs);
    }

    private void notifyObservers(VehicleReservation r) {
        synchronized (observers) {
            for (ReservationObserver o : observers) {
                o.onReservationUpdated(r);
            }
        }
    }

    public void addReservation(VehicleReservation r) {
        reservations.put(r.getReservationId(), r);
        notifyObservers(r);
    }

    public Optional<VehicleReservation> get(int id) {
        return Optional.ofNullable(reservations.get(id));
    }

    public boolean changeStatus(int id, ReservationStatus status) {
        VehicleReservation r = reservations.get(id);
        if (r == null) return false;
        r.setStatus(status);
        notifyObservers(r);
        return true;
    }

    public boolean removeReservation(int id) {
        VehicleReservation r = reservations.remove(id);
        if (r == null) return false;
        notifyObservers(r);
        return true;
    }
}
