package org.example;

import org.example.entity.Interval;
import org.example.entity.User;
import org.example.entity.room.Room;
import org.example.entity.room.RoomFactory;
import org.example.entity.schedule.Schedule;
import org.example.entity.schedule.ScheduleFactory;
import org.example.enums.RSVPStatus;
import org.example.meeting.Meeting;
import org.example.meeting.MeetingScheduler;
import org.example.notification.NotificationService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ZoneId IST = ZoneId.of("Asia/Kolkata");
        ZonedDateTime now = ZonedDateTime.now(IST);

        // Users
        User organizer = new User("Alice Organizer", "alice@example.com");
        User bob = new User("Bob", "bob@example.com");
        User carol = new User("Carol", "carol@example.com");

        // Rooms via Factory
        RoomFactory rf = new RoomFactory();
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(rf.create("STANDARD", 101, 4));
        rooms.add(rf.create("BOARD", 201, 10));

        // Notifications (direct)
        NotificationService notifications = new NotificationService();

        // Scheduler (Singleton)
        MeetingScheduler.init(organizer, rooms, notifications);
        MeetingScheduler scheduler = MeetingScheduler.getInstance();

        // Schedule a one-time meeting
        Interval slot = new Interval(now.plusHours(1), now.plusHours(2));
        Meeting m1 = scheduler.scheduleMeeting(Arrays.asList(bob, carol), slot, "Design Sync");

        // RSVPs (triggers direct notifications)
        scheduler.updateParticipantStatus(m1, bob, RSVPStatus.ACCEPTED);
        scheduler.updateParticipantStatus(m1, carol, RSVPStatus.REJECTED);

        // Recurring meeting (still supported)
        ScheduleFactory sf = new ScheduleFactory();
        Interval first = new Interval(now.plusDays(1).withHour(11).withMinute(0),
                now.plusDays(1).withHour(12).withMinute(0));
        Schedule standup = sf.daily(first, 3);
        Meeting m2 = scheduler.scheduleMeeting(Collections.singletonList(bob), standup, "Daily Standup");

        // Cancel first meeting
        scheduler.cancelMeeting(m1);
    }
}