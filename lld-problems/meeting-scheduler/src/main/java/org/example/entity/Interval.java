package org.example.entity;

import java.time.ZonedDateTime;

/**
 * Half-open interval [start, end) using ZonedDateTime for DST(Day-Light Saving Time) safety.
 */
public final class Interval {
    private final ZonedDateTime start;
    private final ZonedDateTime end;

    public Interval(ZonedDateTime start, ZonedDateTime end) {
        if (start == null || end == null) throw new IllegalArgumentException("start/end null");
        if (!end.isAfter(start)) throw new IllegalArgumentException("end must be after start");
        this.start = start;
        this.end = end;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    /**
     * True if this overlaps other (half-open).
     */
    public boolean overlaps(Interval other) {
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }

    @Override
    public String toString() {
        return "[" + start + " → " + end + ")";
    }
}

