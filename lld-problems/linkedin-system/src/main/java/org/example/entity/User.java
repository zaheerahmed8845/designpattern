package org.example.entity;

import org.example.component.Comment;
import org.example.component.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private final int userId;
    private final LocalDateTime dateOfJoining = LocalDateTime.now();
    private Profile profile;

    private List<User> connections = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private List<CompanyPage> followsCompanies = new ArrayList<>();
    private List<Group> joinedGroups = new ArrayList<>();
    private List<CompanyPage> createdPages = new ArrayList<>();
    private List<Group> createdGroups = new ArrayList<>();

    public User(int userId, String name, Address address, String phone, String email, String password) {
        super(name, address, phone, email, password);
        this.userId = userId;
        this.profile = new Profile();
    }

    public int getUserId() {
        return userId;
    }

    public Profile getProfile() {
        return profile;
    }

    // sample operations
    public ConnectionInvitation sendInvite(User to) {
        ConnectionInvitation ci = new ContentFactory().createConnectionInvitation(this, to);
        // notify the recipient through event bus when they take action
        return ci;
    }

    public Post createPost(String text) {
        return new ContentFactory().createPost(this, text);
    }

    public Comment comment(Post post, String text) {
        return new ContentFactory().createComment(post, this, text);
    }

    public CompanyPage createCompanyPage(int id, String name, String desc, String type, int size) {
        CompanyPage page = new CompanyPage(id, name, desc, type, size, this);
        createdPages.add(page);
        return page;
    }

    public void connect(User other) {
        if (!connections.contains(other)) {
            connections.add(other);
        }
        if (!other.connections.contains(this)) {
            other.connections.add(this);
        }
        profile.getAnalytics().setTotalConnections(connections.size());
        other.profile.getAnalytics().setTotalConnections(other.connections.size());
    }
}
