package org.example.notification;

import org.example.entity.Comment;
import org.example.entity.Message;
import org.example.enums.NotificationType;
import org.example.observer.Post;
import org.example.person.User;

public class NotificationFactory {
    public static Notification create(NotificationType type, User recipient, String content,
                                      Post post, Comment comment, Message message) {
        return switch (type) {
            case POST -> new PostNotification(recipient, content, post);
            case COMMENT -> new CommentNotification(recipient, content, post, comment);
            case MESSAGE -> new MessageNotification(recipient, content, message);
        };
    }
}
