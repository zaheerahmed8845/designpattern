package org.example.meeting;

import org.example.entity.Calendar;
import org.example.entity.Interval;
import org.example.entity.User;
import org.example.entity.room.Room;
import org.example.entity.room.RoomFactory;
import org.example.entity.schedule.Schedule;
import org.example.entity.schedule.ScheduleFactory;
import org.example.enums.RSVPStatus;
import org.example.notification.NotificationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MeetingScheduler {
    private static volatile MeetingScheduler INSTANCE;

    private final User organizer;
    private final Calendar calendar;
    private final List<Room> rooms;
    private final NotificationService notifications;
    private final RoomFactory roomFactory = new RoomFactory();
    private final ScheduleFactory scheduleFactory = new ScheduleFactory();

    private MeetingScheduler(User organizer, List<Room> rooms, NotificationService notifications) {
        this.organizer = organizer;
        this.calendar = organizer.getCalendar();
        this.rooms = new ArrayList<Room>(rooms);
        this.notifications = notifications;
    }

    /**
     * Initialize Singleton once.
     */
    public static MeetingScheduler init(User organizer, List<Room> rooms, NotificationService notifications) {
        if (INSTANCE == null) {
            synchronized (MeetingScheduler.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MeetingScheduler(organizer, rooms, notifications);
                }
            }
        }
        return INSTANCE;
    }

    public static MeetingScheduler getInstance() {
        if (INSTANCE == null) throw new IllegalStateException("Call init() first");
        return INSTANCE;
    }

    /**
     * Convenience: one-time meeting
     */
    public Meeting scheduleMeeting(List<User> attendees, Interval interval, String subject) {
        Schedule schedule = scheduleFactory.oneTime(interval);
        return scheduleMeeting(attendees, schedule, subject);
    }

    /**
     * Generic: with Schedule (supports recurring too)
     */
    public Meeting scheduleMeeting(List<User> attendees, Schedule schedule, String subject) {
        if (attendees == null || schedule == null || subject == null) throw new IllegalArgumentException();

        Interval main = schedule.primaryInterval()
                .orElseThrow();
        Room room = checkRoomsAvailability(attendees.size(), main);
        if (room == null) throw new IllegalStateException("No room available for " + main);

        room.book(main);

        Meeting meeting = new Meeting(UUID.randomUUID().toString(), subject, schedule, room, calendar);
        meeting.addParticipants(new ArrayList<User>(attendees));
        meeting.addParticipants(Collections.singletonList(organizer));
        calendar.addMeeting(meeting);

        // 🔔 notify immediately
        notifications.sendInvites(meeting);
        return meeting;
    }

    public void cancelMeeting(Meeting meeting) {
        // release primary (extend to all occurrences for recurring)
        meeting.getSchedule().primaryInterval().ifPresent(i -> meeting.getRoom().release(i));

        // remove from calendars
        for (User u : meeting.getParticipants()) u.getCalendar().removeMeeting(meeting);
        calendar.removeMeeting(meeting);

        // 🔔 notify
        notifications.sendCancel(meeting);
    }

    public void updateParticipantStatus(Meeting meeting, User user, RSVPStatus status) {
        meeting.updateParticipantStatus(user, status);
        // 🔔 notify
        notifications.sendUpdate(meeting);
    }

    public Room checkRoomsAvailability(int requiredCapacity, Interval interval) {
        for (Room r : rooms) if (r.isAvailableFor(interval, requiredCapacity)) return r;
        return null;
    }

    /**
     * Optional: add rooms later using the factory
     */
    public Room registerRoom(String type, int id, int capacity) {
        Room r = roomFactory.create(type, id, capacity);
        rooms.add(r);
        return r;
    }
}