package org.example.observer;

import org.example.entity.Comment;
import org.example.enums.NotificationType;
import org.example.notification.Notification;
import org.example.notification.NotificationFactory;
import org.example.person.User;
import org.example.strategy.PrivacyStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Post implements Observable {
    private static int SEQ = 1;
    private final String id = "post-" + (SEQ++);
    private final User owner;
    private final String content;
    private final LocalDateTime createdOn = LocalDateTime.now();
    private PrivacyStrategy privacy;
    private final List<Comment> comments = new ArrayList<>();
    private final Set<User> likes = new HashSet<>();
    private final Set<Observer> observers = new HashSet<>();

    public Post(User owner, String content, PrivacyStrategy privacy) {
        this.owner = owner;
        this.content = content;
        this.privacy = privacy;
    }

    public String getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getContent() {
        return content;
    }

    public PrivacyStrategy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(PrivacyStrategy p) {
        this.privacy = p;
    }

    public boolean canView(User actor) {
        return privacy.canView(actor, this);
    }

    public void addComment(Comment c) {
        comments.add(c);
        // notify owner
        Notification nOwner = NotificationFactory.create(
                NotificationType.COMMENT, owner, c.getOwner().getName() + " commented: " + c.getText(), this, c, null);
        owner.update(nOwner);
        // notify other observers (e.g., friends who followed the post)
        notifyObservers(NotificationFactory.create(
                NotificationType.COMMENT, owner, "New comment on a post you follow", this, c, null));
    }

    public void addLike(User u) {
        if (likes.add(u)) {
            Notification nOwner = NotificationFactory.create(
                    NotificationType.POST, owner, u.getName() + " liked your post", this, null, null);
            owner.update(nOwner);
        }
    }

    public List<Comment> getComments() {
        return List.copyOf(comments);
    }

    public int getLikeCount() {
        return likes.size();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Notification n) {
        for (Observer o : observers) if (o != null) o.update(n);
    }

    @Override
    public String toString() {
        return "Post{" + id + ", owner=" + owner.getName() + ", privacy=" + privacy.name() + "}";
    }
}
