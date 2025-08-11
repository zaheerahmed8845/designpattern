package org.example.entity;

import org.example.meeting.Meeting;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Calendar {
    private final List<Meeting> meetings = new CopyOnWriteArrayList<>();

    public List<Meeting> getMeetings() {
        return Collections.unmodifiableList(meetings);
    }

    public void addMeeting(Meeting m) {
        meetings.add(m);
    }

    public void removeMeeting(Meeting m) {
        meetings.remove(m);
    }
}
