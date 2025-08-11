package org.example.entity;

import org.example.enums.RSVPStatus;
import org.example.meeting.Meeting;

import java.util.List;
import java.util.Objects;

public final class User {
    private final String name;
    private final String email;
    private Calendar calendar;

    public User(String name, String email) {
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.calendar = new Calendar();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void respondInvitation(Meeting meeting, RSVPStatus response) {
        meeting.updateParticipantStatus(this, response);
    }

    public List<Meeting> viewMeetings() {
        return calendar.getMeetings();
    }
}
