package org.example;

import org.example.entity.*;
import org.example.enums.LockerSize;
import org.example.locker.assign.BestFitBySizeStrategy;
import org.example.locker.assign.LockerAssignmentStrategy;
import org.example.locker.assign.LockerSelectionContext;
import org.example.locker.strategy.NumericOtpGenerator;
import org.example.locker.strategy.OtpGenerator;
import org.example.repository.InMemoryLockerRepository;
import org.example.repository.InMemoryPackageRepository;
import org.example.repository.LockerRepository;
import org.example.repository.PackageRepository;
import org.example.service.LockerService;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // 1) Create repositories
        LockerRepository lockerRepo = new InMemoryLockerRepository();
        PackageRepository packageRepo = new InMemoryPackageRepository();

        // 2) Seed locker locations
        LockerLocation loc1 = new LockerLocation("LOC1", 12.9716, 77.5946,
                LocalTime.of(8, 0), LocalTime.of(22, 0));
        LockerLocation loc2 = new LockerLocation("LOC2", 12.9352, 77.6245,
                LocalTime.of(8, 0), LocalTime.of(22, 0));

        Locker l1 = new Locker("L1", LockerSize.SMALL, "LOC1");
        Locker l2 = new Locker("L2", LockerSize.MEDIUM, "LOC1");
        Locker l3 = new Locker("L3", LockerSize.LARGE, "LOC2");

        loc1.addLocker(l1);
        loc1.addLocker(l2);
        loc2.addLocker(l3);

        lockerRepo.saveLocation(loc1);
        lockerRepo.saveLocation(loc2);
        lockerRepo.saveLocker(l1);
        lockerRepo.saveLocker(l2);
        lockerRepo.saveLocker(l3);

        // 3) Create LockerService with BestFitBySizeStrategy
        LockerAssignmentStrategy strategy = new BestFitBySizeStrategy();
        LockerService service = new LockerService(lockerRepo, packageRepo, strategy);

        // 4) Create a customer, order, and package
        Customer customer = new Customer("C1", "Zaheer", "zaheer@example.com", "9999999999");

        Order order = new Order("O1", "LOC1", "C1");
        order.addItem(new Item("I1", 1));

        // Generate OTP for package
        OtpGenerator otpGen = new NumericOtpGenerator(6);
        String otpCode = otpGen.generate();
        LockerPackage pkg = new LockerPackage(
                "PKG1",
                2.0, // package size
                order,
                3, // code valid days
                null, // lockerId will be assigned when we pick a locker
                otpCode,
                LocalDateTime.now()
        );

        // 5) Request locker for package
        LockerSelectionContext ctx = new LockerSelectionContext(lockerRepo, "LOC1", null, null);
        var assignedLockerOpt = service.requestLocker(pkg, ctx);

        if (assignedLockerOpt.isPresent()) {
            Locker assignedLocker = assignedLockerOpt.get();
            System.out.printf("Assigned Locker: %s at Location: %s with OTP: %s%n",
                    assignedLocker.getLockerId(), assignedLocker.getLocationId(), otpCode);

            // Simulate delivery
            pkg = new LockerPackage(
                    pkg.getPackageId(),
                    pkg.getPackageSize(),
                    pkg.getOrder(),
                    3,
                    assignedLocker.getLockerId(),
                    otpCode,
                    LocalDateTime.now()
            );
            assignedLocker.addPackage(pkg);

            // Simulate customer pickup with OTP
            boolean pickupSuccess = service.pickup(assignedLocker.getLockerId(), otpCode);
            System.out.println("Pickup success? " + pickupSuccess);
        } else {
            System.out.println("No locker available for assignment.");
        }
    }
}