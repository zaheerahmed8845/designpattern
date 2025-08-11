package org.example.entity.room;

import org.example.entity.Interval;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRoom implements Room {
    private final int id;
    private final int capacity;
    private final List<Interval> booked = new ArrayList<>();
    private boolean enabled = true;

    protected AbstractRoom(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int id() {
        return id;
    }

    public int capacity() {
        return capacity;
    }

    public synchronized boolean isAvailableFor(Interval interval, int requiredCapacity) {
        if (!enabled) return false;
        if (requiredCapacity > capacity) return false;
        for (Interval b : booked) if (b.overlaps(interval)) return false;
        return true;
    }

    public synchronized void book(Interval interval) {
        if (!isAvailableFor(interval, 0))
            throw new IllegalStateException("Room#" + id + " unavailable for " + interval);
        booked.add(interval);
    }

    public synchronized void release(Interval interval) {
        booked.removeIf(b -> b.overlaps(interval) || b.equals(interval));
    }

    public void setEnabled(boolean on) {
        this.enabled = on;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + "(cap=" + capacity + ")";
    }
}
