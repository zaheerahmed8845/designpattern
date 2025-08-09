package org.example.locker.assign;

import org.example.entity.Locker;
import org.example.entity.LockerPackage;

import java.util.Optional;

public interface LockerAssignmentStrategy {
    Optional<Locker> assign(LockerPackage lockerPackage, LockerSelectionContext ctx);
}
