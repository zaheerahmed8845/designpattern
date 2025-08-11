package org.example.entity.room;

import org.example.entity.Interval;

public interface Room {
    int id();

    int capacity();

    boolean isAvailableFor(Interval interval, int requiredCapacity);

    void book(Interval interval);

    void release(Interval interval);
}
