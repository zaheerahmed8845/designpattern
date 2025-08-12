package org.example.service;

import java.time.Duration;
import java.util.List;

public interface SeatLockingService {
    boolean lock(String showId, List<String> seatIds, String holder, Duration ttl);

    void release(String showId, List<String> seatIds, String holder);

    boolean validate(String showId, List<String> seatIds, String holder);
}
