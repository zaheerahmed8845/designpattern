package org.example.meeting;

import org.example.entity.Calendar;
import org.example.entity.User;
import org.example.entity.room.Room;
import org.example.entity.schedule.Schedule;
import org.example.enums.RSVPStatus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Meeting {
    private final String id;
    private final String subject;
    private final Map<User, RSVPStatus> participantStatus = new LinkedHashMap<>();
    private final Schedule schedule;
    private Room room;
    private Calendar calendar; // owner

    public Meeting(String id, String subject, Schedule schedule, Room room, Calendar calendar) {
        this.id = id;
        this.subject = subject;
        this.schedule = schedule;
        this.room = room;
        this.calendar = calendar;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room r) {
        this.room = r;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void addParticipants(List<User> participants) {
        for (User u : participants) {
            participantStatus.putIfAbsent(u, RSVPStatus.PENDING);
            // show the meeting on each participant’s calendar for visibility
            u.getCalendar().addMeeting(this);
        }
    }

    public void updateParticipantStatus(User user, RSVPStatus status) {
        if (!participantStatus.containsKey(user))
            throw new IllegalArgumentException("User is not invited: " + user.getEmail());
        participantStatus.put(user, status);
    }

    public List<User> getParticipants() {
        return new ArrayList<>(participantStatus.keySet());
    }

    public List<User> getAcceptedParticipants() {
        return filterBy(RSVPStatus.ACCEPTED);
    }

    public List<User> getPendingParticipants() {
        return filterBy(RSVPStatus.PENDING);
    }

    public List<User> getRejectedParticipants() {
        return filterBy(RSVPStatus.REJECTED);
    }

    private List<User> filterBy(RSVPStatus s) {
        return participantStatus.entrySet().stream()
                .filter(e -> e.getValue() == s)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Meeting#" + id + " \"" + subject + "\" " + schedule + " " + room;
    }
}
