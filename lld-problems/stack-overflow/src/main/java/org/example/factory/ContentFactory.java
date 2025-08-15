package org.example.factory;

import org.example.composite.Comment;
import org.example.entity.Answer;
import org.example.entity.Notification;
import org.example.entity.Question;
import org.example.entity.Tag;
import org.example.user.User;

import java.util.List;

public abstract class ContentFactory {
    abstract Question newQuestion(User owner, String title, String body, List<Tag> tags);

    abstract Answer newAnswer(User owner, String content);

    abstract Comment newComment(User owner, String content);

    abstract Notification newNotification(User account, String content);
}
