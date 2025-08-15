package org.example.command;

import org.example.entity.Answer;
import org.example.entity.Question;
import org.example.event.CommentAddedEvent;
import org.example.event.DomainEventPublisher;
import org.example.factory.DefaultContentFactory;
import org.example.user.UserDirectory;

import java.util.Map;

public class AddCommentHandler implements CommandHandler<AddCommentCommand> {
    private final UserDirectory users;
    private final Map<Long, Question> questions;
    private final Map<Long, Answer> answers;
    private final DefaultContentFactory factory;
    private final DomainEventPublisher events;

    public AddCommentHandler(UserDirectory users, Map<Long, Question> qs, Map<Long, Answer> as, DefaultContentFactory f, DomainEventPublisher e) {
        this.users = users;
        this.questions = qs;
        this.answers = as;
        this.factory = f;
        this.events = e;
    }

    public Class<AddCommentCommand> type() {
        return AddCommentCommand.class;
    }

    public void handle(AddCommentCommand c) {
        var author = users.find(c.authorId);
        var comment = factory.newComment(author, c.text);
        if (c.target == PostTarget.QUESTION) {
            var q = questions.get(c.parentId);
            author.addCommentToQuestion(q, comment);
            events.publish(new CommentAddedEvent(q.getId(), false, comment.getId(), author.getId()));
        } else {
            var a = answers.get(c.parentId);
            author.addCommentToAnswer(a, comment);
            events.publish(new CommentAddedEvent(a.getId(), true, comment.getId(), author.getId()));
        }
    }
}
