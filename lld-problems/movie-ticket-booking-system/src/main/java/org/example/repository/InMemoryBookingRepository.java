package org.example.repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBookingRepository implements BookingRepository {
    // final arbiter of uniqueness
    private final Set<String> booked = ConcurrentHashMap.newKeySet(); // key = showId:seatId

    private String key(String showId, String seatId) {
        return showId + ":" + seatId;
    }

    public boolean tryPersistSeats(String showId, List<String> seatIds, String bookingId) {
        // emulate atomic insert-all-or-none
        List<String> keys = seatIds.stream().map(id -> key(showId, id)).toList();
        synchronized (booked) {
            for (String k : keys) if (booked.contains(k)) return false;
            booked.addAll(keys);
            return true;
        }
    }
}