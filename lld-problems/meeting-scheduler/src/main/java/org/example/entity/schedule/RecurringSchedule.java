package org.example.entity.schedule;

import org.example.entity.Interval;

import java.time.Period;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Minimal recurring schedule: daily with count (demo-friendly).
 */
final class RecurringSchedule implements Schedule {
    private final Interval base;       // first occurrence window
    private final int count;           // number of occurrences
    private final Period period;       // recurrence period (e.g., P1D)

    public RecurringSchedule(Interval base, int count, Period period) {
        if (count <= 0) throw new IllegalArgumentException("count must be > 0");
        this.base = base;
        this.count = count;
        this.period = period;
    }

    public List<Interval> expandWithin(Interval window) {
        List<Interval> out = new ArrayList<>(count);
        ZonedDateTime s = base.getStart();
        ZonedDateTime e = base.getEnd();
        for (int i = 0; i < count; i++) {
            Interval occ = new Interval(s, e);
            if (occ.overlaps(window)) out.add(occ);
            s = s.plus(period);
            e = e.plus(period);
        }
        return out;
    }

    @Override
    public String toString() {
        return "Recurring(" + period + " x" + count + ")";
    }
}
