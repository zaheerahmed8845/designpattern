package org.example.template;

import org.example.entity.AuthorizationService;
import org.example.entity.Question;
import org.example.enums.Permission;
import org.example.event.DomainEventPublisher;
import org.example.event.QuestionClosedEvent;
import org.example.user.Moderator;
import org.example.user.User;

import java.util.Objects;

public class CloseQuestionAction extends ModerationAction {
    private final AuthorizationService auth = new AuthorizationService();
    private final Moderator moderator;
    private final Question question;
    private final String reason;
    private final DomainEventPublisher events;

    public CloseQuestionAction(Moderator m, Question q, String reason, DomainEventPublisher events) {
        this.moderator = m;
        this.question = q;
        this.reason = reason;
        this.events = events;
    }

    protected void validate(User actor) {
        Objects.requireNonNull(question);
    }

    protected void checkPermissions(User actor) {
        auth.check(moderator, Permission.MOD_CLOSE);
    }

    protected void apply() {
        question.close(reason);
        events.publish(new QuestionClosedEvent(question.getId(), reason));
    }
}
