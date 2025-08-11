package org.example.entity.schedule;

import org.example.entity.Interval;

import java.util.List;

final class OneTimeSchedule implements Schedule {
    private final Interval interval;

    public OneTimeSchedule(Interval interval) {
        this.interval = interval;
    }

    public List<Interval> expandWithin(Interval window) {
        return interval.overlaps(window) ? List.of(interval) : List.of();
    }

    @Override
    public String toString() {
        return "OneTime" + interval;
    }
}
