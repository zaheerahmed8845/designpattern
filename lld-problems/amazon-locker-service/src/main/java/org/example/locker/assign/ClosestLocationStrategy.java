package org.example.locker.assign;

import org.example.entity.Locker;
import org.example.entity.LockerPackage;
import org.example.enums.LockerState;

import java.util.Comparator;
import java.util.Optional;

public class ClosestLocationStrategy implements LockerAssignmentStrategy {
    @Override
    public Optional<Locker> assign(LockerPackage pkg, LockerSelectionContext ctx) {
        var repo = ctx.lockerRepository();

        // 1) Try preferred location if provided
        if (ctx.preferredLocation() != null) {
            var atPreferred = repo.findByLocationId(ctx.preferredLocation()).stream()
                    .filter(l -> l.getLockerState() == LockerState.AVAILABLE)
                    .findFirst();
            if (atPreferred.isPresent()) return atPreferred;
        }

        // 2) Otherwise pick by distance
        if (ctx.customerLat() != null && ctx.customerLon() != null) {
            return repo.findAll().stream()
                    .filter(l -> l.getLockerState() == LockerState.AVAILABLE)
                    .min(Comparator.comparing(l ->
                            Haversine.distanceKm(ctx.customerLat(), ctx.customerLon(),
                                    repo.locationLat(l.getLocationId()),
                                    repo.locationLon(l.getLocationId()))));
        }
        return Optional.empty();
    }
}
