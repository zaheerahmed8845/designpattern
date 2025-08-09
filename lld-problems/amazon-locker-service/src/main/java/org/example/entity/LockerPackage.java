package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class LockerPackage extends Package {
    private int codeValidDays;
    private String lockerId;
    private String code;
    private LocalDateTime packageDeliveryTime;

    public LockerPackage(String packageId,
                         double packageSize,
                         Order order,
                         int codeValidDays,
                         String lockerId,
                         String code,
                         LocalDateTime packageDeliveryTime) {
        super(packageId, packageSize, order);
        this.codeValidDays = codeValidDays;
        this.lockerId = lockerId;
        this.code = Objects.requireNonNull(code);
        this.packageDeliveryTime = Objects.requireNonNull(packageDeliveryTime);
    }

    public void setLockerId(String lockerId) {           // <- new setter
        this.lockerId = Objects.requireNonNull(lockerId);
    }


    public boolean isValidCode() {
        return packageDeliveryTime.plusDays(codeValidDays).isAfter(LocalDateTime.now());
    }

    public boolean verifyCode(String code) {
        return isValidCode() && this.code.equals(code);
    }

    // getters
    public int getCodeValidDays() {
        return codeValidDays;
    }

    public String getLockerId() {
        return lockerId;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getPackageDeliveryTime() {
        return packageDeliveryTime;
    }
}

