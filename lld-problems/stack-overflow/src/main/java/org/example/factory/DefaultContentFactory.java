package org.example.factory;

import org.example.composite.Comment;
import org.example.entity.Answer;
import org.example.entity.Notification;
import org.example.entity.Question;
import org.example.entity.Tag;
import org.example.user.User;
import org.example.util.IdGen;

import java.util.List;

public class DefaultContentFactory extends ContentFactory {
    @Override
    public Question newQuestion(User owner, String title, String body, List<Tag> tags) {
        return new Question(IdGen.next(), title, body, owner, tags);
    }

    @Override
    public Answer newAnswer(User owner, String content) {
        return new Answer(IdGen.next(), content, owner);
    }

    @Override
    public Comment newComment(User owner, String content) {
        return new Comment(IdGen.next(), owner, content);
    }

    @Override
    Notification newNotification(User account, String content) {
        return new Notification(IdGen.next(), account, content);
    }
}
