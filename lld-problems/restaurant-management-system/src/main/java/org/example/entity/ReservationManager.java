package org.example.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ReservationManager {
    private static final ReservationManager INSTANCE = new ReservationManager();
    private final Map<String, Reservation> byId = new ConcurrentHashMap<>();

    private ReservationManager() {
    }

    public static ReservationManager getInstance() {
        return INSTANCE;
    }

    public void save(Reservation r) {
        byId.putIfAbsent(r.getReservationId(), r);
    }

    public Reservation find(String id) {
        return byId.get(id);
    }
}
