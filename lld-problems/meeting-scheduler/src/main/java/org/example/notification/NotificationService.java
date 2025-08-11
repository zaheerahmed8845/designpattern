package org.example.notification;

import org.example.entity.User;
import org.example.meeting.Meeting;

final public class NotificationService {
    public void sendInvites(Meeting m) {
        for (User u : m.getParticipants()) {
            System.out.printf("[INVITE] To: %-22s | %s | %s | %s%n",
                    u.getEmail(), m.getSubject(),
                    m.getSchedule().primaryInterval().orElse(null), m.getRoom());
        }
    }

    public void sendUpdate(Meeting m) {
        for (User u : m.getParticipants()) {
            System.out.printf("[UPDATE] To: %-22s | %s | %s | %s%n",
                    u.getEmail(), m.getSubject(),
                    m.getSchedule().primaryInterval().orElse(null), m.getRoom());
        }
    }

    public void sendCancel(Meeting m) {
        for (User u : m.getParticipants()) {
            System.out.printf("[CANCEL] To: %-22s | %s%n", u.getEmail(), m.getSubject());
        }
    }
}
