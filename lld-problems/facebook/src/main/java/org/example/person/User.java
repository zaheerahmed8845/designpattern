package org.example.person;

import org.example.entity.*;
import org.example.enums.NotificationType;
import org.example.notification.Notification;
import org.example.notification.NotificationFactory;
import org.example.observer.Observer;
import org.example.observer.Post;
import org.example.search.SearchCatalog;
import org.example.state.AccountState;
import org.example.state.ActiveState;
import org.example.strategy.PrivacyStrategy;

import java.util.*;


public class User extends Person implements Observer,
        PostFunctionsByUser, CommentFunctionsByUser, GroupFunctionsByUser, PageFunctionsByUser {

    private AccountState accountState = new ActiveState();
    final Set<User> friends = new HashSet<>();
    final List<Post> timeline = new ArrayList<>();
    final List<Notification> inbox = new ArrayList<>();
    final Set<Group> groups = new HashSet<>();
    final Set<Page> pages = new HashSet<>();

    public User(String name) {
        super(name);
    }

    /* ==== Account state ==== */
    public void setAccountState(AccountState state) {
        this.accountState = state;
    }

    public AccountState getAccountState() {
        return accountState;
    }

    /* ==== Friend ops ==== */
    public boolean isFriend(User other) {
        return friends.contains(other);
    }

    public void addFriend(User u) {
        friends.add(u);
    }

    public Set<User> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    /* ==== Observer ==== */
    @Override
    public void update(Notification notification) {
        inbox.add(notification);
    }

    public List<Notification> getInbox() {
        return List.copyOf(inbox);
    }

    /* ==== ISP: Posts ==== */
    @Override
    public Post createPost(String content, PrivacyStrategy privacy) {
        if (!accountState.canPost()) throw new IllegalStateException("Account can't post: " + accountState.name());
        Post p = new Post(this, content, privacy);
        timeline.add(p);
        // notify friends who can view
        for (User f : friends) {
            if (p.canView(f)) {
                Notification n = NotificationFactory.create(
                        NotificationType.POST, f, this.getName() + " posted: " + content, p, null, null);
                p.addObserver(f); // observe future comments/likes on this post
                f.update(n);
            }
        }
        // index into global search
        SearchCatalog.getInstance().indexPost(p);
        return p;
    }

    @Override
    public void likePost(Post post) {
        post.addLike(this);
    }

    @Override
    public Comment commentOnPost(Post post, String text) {
        return createComment(post, text);
    }

    @Override
    public void sharePost(Post post) {
        // minimal share: re-post with same privacy
        createPost("Shared: " + post.getContent(), post.getPrivacy());
    }

    /* ==== ISP: Comments ==== */
    @Override
    public Comment createComment(Post post, String text) {
        Comment c = new Comment(this, text);
        post.addComment(c);
        return c;
    }

    @Override
    public void likeComment(Comment c) {
        c.addLike(this);
    }

    /* ==== ISP: Groups ==== */
    @Override
    public void joinGroup(Group g) {
        g.addUser(this);
        groups.add(g);
    }

    @Override
    public void leaveGroup(Group g) {
        g.removeUser(this);
        groups.remove(g);
    }

    @Override
    public void createGroup(Group g) {
        g.addUser(this);
        groups.add(g);
    }

    /* ==== ISP: Pages ==== */
    @Override
    public void followPage(Page p) {
        p.addFollower(this);
        pages.add(p);
    }

    @Override
    public void unfollowPage(Page p) {
        p.removeFollower(this);
        pages.remove(p);
    }

    @Override
    public Post createPagePost(Page p, String content, PrivacyStrategy privacy) {
        return p.createPost(this, content, privacy);
    }

    /* ==== Messaging ==== */
    public Message sendMessage(String text, User... recipients) {
        if (!accountState.canSendMessage())
            throw new IllegalStateException("Account can't message: " + accountState.name());
        Message m = new Message(this, Arrays.asList(recipients), text);
        m.send();
        return m;
    }

    @Override
    public String toString() {
        return "User(" + name + ")";
    }
}
