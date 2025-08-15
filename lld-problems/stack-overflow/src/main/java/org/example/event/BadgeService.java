package org.example.event;

import org.example.entity.Badge;
import org.example.user.UserDirectory;

import java.util.HashMap;
import java.util.Map;

public class BadgeService implements DomainEventHandler<AnswerAddedEvent> {
    private final Map<Long, Integer> answerCounts = new HashMap<>();
    private final DomainEventPublisher events;
    private final UserDirectory users;

    public BadgeService(DomainEventPublisher events, UserDirectory users) {
        this.events = events;
        this.users = users;
    }

    @Override
    public void handle(AnswerAddedEvent e) {
        int n = answerCounts.merge(e.authorId, 1, Integer::sum);
        if (n == 1) { // simple example: first answer badge
            var u = users.find(e.authorId);
            if (u != null) {
                u.addBadge(new Badge("First Answer", "Posted first answer"));
                events.publish(new BadgeAwardedEvent(e.authorId, "First Answer"));
            }
        }
    }
}
