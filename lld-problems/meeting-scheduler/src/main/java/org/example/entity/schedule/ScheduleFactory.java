package org.example.entity.schedule;

import org.example.entity.Interval;

import java.time.Period;

public final class ScheduleFactory {
    public Schedule oneTime(Interval i) {
        return new OneTimeSchedule(i);
    }

    public Schedule daily(Interval first, int count) {
        return new RecurringSchedule(first, count, Period.ofDays(1));
    }
}
