package org.example.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySeatLockingService implements SeatLockingService {
    static final class Lock {
        final String holder;
        final Instant expiresAt;

        Lock(String h, Instant e) {
            holder = h;
            expiresAt = e;
        }

        boolean expired() {
            return Instant.now().isAfter(expiresAt);
        }
    }

    // key = showId:seatId
    private final Map<String, Lock> locks = new HashMap<>();

    private String key(String show, String seat) {
        return show + ":" + seat;
    }

    public synchronized boolean lock(String showId, List<String> seatIds, String holder, Duration ttl) {
        Instant exp = Instant.now().plus(ttl);
        // check phase
        for (String seatId : seatIds) {
            Lock l = locks.get(key(showId, seatId));
            if (l != null && !l.expired() && !l.holder.equals(holder)) return false;
        }
        // set phase
        for (String seatId : seatIds) locks.put(key(showId, seatId), new Lock(holder, exp));
        return true;
    }

    public synchronized void release(String showId, List<String> seatIds, String holder) {
        for (String seatId : seatIds) {
            String k = key(showId, seatId);
            Lock l = locks.get(k);
            if (l != null && holder.equals(l.holder)) locks.remove(k);
        }
    }

    public synchronized boolean validate(String showId, List<String> seatIds, String holder) {
        for (String seatId : seatIds) {
            Lock l = locks.get(key(showId, seatId));
            if (l == null || l.expired() || !holder.equals(l.holder)) return false;
        }
        return true;
    }
}
