package org.example.repository;

import java.util.List;

public interface BookingRepository {
    boolean tryPersistSeats(String showId, List<String> seatIds, String bookingId); // UNIQUE(show,seat)

}
