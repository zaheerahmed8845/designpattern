package org.example.locker.assign;

import org.example.repository.LockerRepository;

public record LockerSelectionContext(
        LockerRepository lockerRepository,
        String preferredLocation,     // optional: a location name/id user picked
        Double customerLat,           // optional: for nearest-location strategies
        Double customerLon
) {
}
