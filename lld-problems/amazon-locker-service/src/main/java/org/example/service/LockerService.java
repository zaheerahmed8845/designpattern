package org.example.service;

import org.example.entity.Locker;
import org.example.entity.LockerPackage;
import org.example.enums.LockerState;
import org.example.locker.assign.LockerAssignmentStrategy;
import org.example.locker.assign.LockerSelectionContext;
import org.example.repository.LockerRepository;
import org.example.repository.PackageRepository;

import java.util.Objects;
import java.util.Optional;

public class LockerService {
    private final LockerRepository lockerRepo;
    private final PackageRepository packageRepo;
    private LockerAssignmentStrategy assignmentStrategy;

    public LockerService(LockerRepository lockerRepo,
                         PackageRepository packageRepo,
                         LockerAssignmentStrategy strategy) {
        this.lockerRepo = Objects.requireNonNull(lockerRepo);
        this.packageRepo = Objects.requireNonNull(packageRepo);
        this.assignmentStrategy = Objects.requireNonNull(strategy);
    }

    public Optional<Locker> requestLocker(LockerPackage lockerPackage, LockerSelectionContext ctx) {
        var chosen = assignmentStrategy.assign(lockerPackage, ctx);
        chosen.ifPresent(locker -> {
            if (locker.addPackage(lockerPackage)) {
                packageRepo.save(lockerPackage);
            } else {
                throw new IllegalStateException("Locker no longer available");
            }
        });
        return chosen;
    }

    public boolean verifyOTP(String lockerId, String code) {
        var locker = lockerRepo.findById(lockerId).orElse(null);
        if (locker == null || locker.getCurrentPackage() == null) return false;
        return locker.getCurrentPackage().verifyCode(code);
    }

    public boolean pickup(String lockerId, String code) {
        var lockerOpt = lockerRepo.findById(lockerId);
        if (lockerOpt.isEmpty()) return false;
        var locker = lockerOpt.get();
        if (locker.getCurrentPackage() == null) return false;
        if (!locker.getCurrentPackage().verifyCode(code)) return false;

        packageRepo.delete(locker.getCurrentPackage().getPackageId());
        return locker.removePackage();
    }

    public void setAssignmentStrategy(LockerAssignmentStrategy strategy) {
        this.assignmentStrategy = Objects.requireNonNull(strategy);
    }

    public LockerState lockerState(String lockerId) {
        return lockerRepo.findById(lockerId).map(Locker::getLockerState).orElse(null);
    }
}