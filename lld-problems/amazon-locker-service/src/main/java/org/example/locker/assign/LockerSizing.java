package org.example.locker.assign;

import org.example.enums.LockerSize;

public final class LockerSizing {
    private LockerSizing() {
    }

    // Map continuous package size (volume/score) to enum bucket
    public static LockerSize map(double size) {
        if (size <= 1.0) return LockerSize.EXTRA_SMALL;
        if (size <= 2.0) return LockerSize.SMALL;
        if (size <= 3.0) return LockerSize.MEDIUM;
        if (size <= 5.0) return LockerSize.LARGE;
        if (size <= 8.0) return LockerSize.EXTRA_LARGE;
        return LockerSize.DOUBLE_EXTRA_LARGE;
    }
}
