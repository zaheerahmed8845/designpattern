package org.example.entity.schedule;

import org.example.entity.Interval;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

sealed public interface Schedule permits OneTimeSchedule, RecurringSchedule {
    /**
     * Expand occurrences that fall (even partially) within window.
     */
    List<Interval> expandWithin(Interval window);

    /**
     * A convenience for single-slot schedules; returns the first interval if present.
     */
    default Optional<Interval> primaryInterval() {
        var all = expandWithin(new Interval(ZonedDateTime.ofInstant(Instant.EPOCH, ZoneOffset.UTC),
                ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.MAX_VALUE), ZoneOffset.UTC)));
        return all.isEmpty() ? Optional.empty() : Optional.of(all.get(0));
    }
}
