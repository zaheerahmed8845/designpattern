package org.example.user;

import org.example.composite.Comment;
import org.example.decorator.BaseUserCapabilities;
import org.example.decorator.UserCapability;
import org.example.entity.*;
import org.example.enums.Permission;
import org.example.enums.UserStatus;
import org.example.util.IdGen;

import java.util.*;

public class User {
    private final long id;
    private String name;
    private int reputationPoints;
    private UserStatus status = UserStatus.ACTIVE;
    private final List<Badge> badges = new ArrayList<>();
    private Question currentDraft;
    private final Set<Role> roles = new HashSet<>();
    private UserCapability capabilities = new BaseUserCapabilities();

    public User(long id, String name, int reputationPoints) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.reputationPoints = Math.max(0, reputationPoints);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReputationPoints() {
        return reputationPoints;
    }

    public UserStatus getStatus() {
        return status;
    }

    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }

    public Question getCurrentDraft() {
        return currentDraft;
    }

    public void addBadge(Badge b) {
        badges.add(Objects.requireNonNull(b));
    }

    public void setStatus(UserStatus s) {
        this.status = Objects.requireNonNull(s);
    }

    public void increaseReputation(int delta) {
        reputationPoints = Math.max(0, reputationPoints + delta);
    }

    public void decreaseReputation(int delta) {
        reputationPoints = Math.max(0, reputationPoints - Math.abs(delta));
    }

    public void addRole(Role r) {
        roles.add(Objects.requireNonNull(r));
    }

    public boolean has(Permission p) {
        return roles.stream().anyMatch(r -> r.getPermissions().contains(p));
    }

    public void setCapabilities(UserCapability c) {
        this.capabilities = Objects.requireNonNull(c);
    }

    // --- Behavior aligned with diagram ---
    public Question create(String title, String body, List<Tag> tags) {
        this.currentDraft = new Question(IdGen.next(), title, body, this, tags);
        return currentDraft;
    }

    public boolean addAnswer(Question q, Answer answer) {
        requireActive();
        if (!capabilities.canAnswer(this)) throw new IllegalStateException("Not allowed to answer");
        if (answer.getPostedBy() == null) answer.setPostedBy(this);
        q.addAnswer(answer);
        return true;
    }

    public boolean createComment(Comment comment) {
        requireActive();
        if (!capabilities.canComment(this)) throw new IllegalStateException("Not allowed to comment");
        return true;
    }

    public boolean addCommentToQuestion(Question q, Comment c) {
        requireActive();
        if (!capabilities.canComment(this)) throw new IllegalStateException("Not allowed to comment");
        if (c.getPostedBy() == null) c.setPostedBy(this);
        q.addComment(c);
        return true;
    }

    public boolean addCommentToAnswer(Answer a, Comment c) {
        requireActive();
        if (!capabilities.canComment(this)) throw new IllegalStateException("Not allowed to comment");
        if (c.getPostedBy() == null) c.setPostedBy(this);
        a.addComment(c);
        return true;
    }

    public void upvote(Question q) {
        q.upvote();
    }

    public void downvote(Question q) {
        q.downvote();
    }

    public void voteToCloseQuestion(Question q, String reason) {
        q.addCloseVote(this, reason);
    }

    public void voteToDeleteQuestion(Question q) {
        q.addDeleteVote(this);
    }

    public void flagQuestion(Question q, String reason) {
        q.addFlag(this, reason);
    }

    public void flagAnswer(Answer a, String reason) {
        a.addFlag(this, reason);
    }

    public void acceptAnswer(Answer a) {
        a.setAccepted(true);
    }

    public void publishQuestion(Question q) {
        q.publish();
    }

    public void addBounty(Question q, Bounty bounty) {
        Objects.requireNonNull(bounty);
        q.setBounty(bounty);
        bounty.setQuestion(q);
        decreaseReputation(bounty.getReputationPoints());
    }

    private void requireActive() {
        if (status != UserStatus.ACTIVE) throw new IllegalStateException("User is not active");
    }
}
