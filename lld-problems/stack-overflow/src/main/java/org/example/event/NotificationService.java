package org.example.event;

public class NotificationService implements DomainEventHandler<DomainEvent> {
    @Override
    public void handle(DomainEvent e) {
        if (e instanceof AnswerAddedEvent a) {
            System.out.println("[Notify] New answer " + a.answerId + " on question " + a.questionId);
        } else if (e instanceof CommentAddedEvent c) {
            System.out.println("[Notify] New comment " + c.commentId + (c.onAnswer ? " on answer" : " on question ") + c.parentId);
        } else if (e instanceof QuestionClosedEvent qc) {
            System.out.println("[Notify] Question " + qc.questionId + " closed: " + qc.reason);
        } else if (e instanceof BadgeAwardedEvent b) {
            System.out.println("[Notify] Congrats user " + b.userId + " for badge: " + b.badge);
        }
    }
}