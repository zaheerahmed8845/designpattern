package org.example.event;

import org.example.entity.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements EventListener {
    private static final NotificationService INSTANCE = new NotificationService();
    private final List<Notification> outbox = new ArrayList<>();

    private NotificationService() {
    }

    public static NotificationService getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEvent(Event e) {
        if (e instanceof PostCreatedEvent pc) {
            outbox.add(new Notification("New post from " + pc.getPost().getAuthor().getName()));
        } else if (e instanceof CommentAddedEvent cc) {
            outbox.add(new Notification("New comment on a post by " + cc.getPost().getAuthor().getName()));
        } else if (e instanceof ConnectionRequestedEvent cr) {
            String msg = cr.isAccepted() ?
                    "Connection accepted between " + cr.getSender().getName() + " and " + cr.getRecipient().getName() :
                    "Connection ignored between " + cr.getSender().getName() + " and " + cr.getRecipient().getName();
            outbox.add(new Notification(msg));
        }
    }

    public List<Notification> drain() {
        List<Notification> copy = new ArrayList<>(outbox);
        outbox.clear();
        return copy;
    }
}
