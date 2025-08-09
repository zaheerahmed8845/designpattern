package org.example.locker.assign;

import org.example.entity.Locker;
import org.example.entity.LockerPackage;
import org.example.enums.LockerState;

import java.util.Comparator;
import java.util.Optional;

public class BestFitBySizeStrategy implements LockerAssignmentStrategy {
    @Override
    public Optional<Locker> assign(LockerPackage pkg, LockerSelectionContext ctx) {
        return ctx.lockerRepository()
                .findAll()
                .stream()
                .filter(l -> l.getLockerState() == LockerState.AVAILABLE)
                .filter(l -> l.getLockerSize().ordinal() >= LockerSizing.map(pkg.getPackageSize()).ordinal())
                .sorted(Comparator.comparing(l -> l.getLockerSize().ordinal()))
                .findFirst();
    }
}
