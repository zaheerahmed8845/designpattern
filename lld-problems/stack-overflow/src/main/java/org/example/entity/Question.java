package org.example.entity;

import org.example.composite.Comment;
import org.example.enums.QuestionStatus;
import org.example.user.User;

import java.time.LocalDateTime;
import java.util.*;

public class Question {
    private final long id;
    private String title;
    private String content;
    private final User createdBy;
    private final List<Tag> tags = new ArrayList<>();
    private final List<Answer> answers = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private int viewCount;
    private int downvotes;
    private int upvotes;
    private final LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime modificationDate = creationDate;
    private Bounty bounty;
    private QuestionStatus status = QuestionStatus.ACTIVE;
    private final Map<Long, String> closeVotesByUser = new HashMap<>();
    private final Set<Long> deleteVotesByUser = new HashSet<>();
    private final Map<Long, String> flagsByUser = new HashMap<>();

    public Question(long id, String title, String content, User createdBy, List<Tag> tags) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
        this.createdBy = Objects.requireNonNull(createdBy);
        if (tags != null) this.tags.addAll(tags);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public List<Tag> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public List<Answer> getAnswers() {
        return Collections.unmodifiableList(answers);
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public QuestionStatus getStatus() {
        return status;
    }

    public Bounty getBounty() {
        return bounty;
    }

    public void setBounty(Bounty bounty) {
        this.bounty = bounty;
        this.status = QuestionStatus.BOUNTIED;
        touch();
    }

    public void addComment(Comment c) {
        comments.add(Objects.requireNonNull(c));
        touch();
    }

    public void addAnswer(Answer a) {
        answers.add(Objects.requireNonNull(a));
        touch();
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        downvotes++;
    }

    public void addCloseVote(User voter, String reason) {
        closeVotesByUser.put(voter.getId(), reason);
    }

    public void addDeleteVote(User voter) {
        deleteVotesByUser.add(voter.getId());
    }

    public void addFlag(User flagger, String reason) {
        flagsByUser.put(flagger.getId(), reason);
        this.status = QuestionStatus.FLAGGED;
    }

    public void notifyClosedQuestion() { /* hook */ }

    public void publish() {
        touch();
    }

    public void close(String reason) {
        this.status = QuestionStatus.CLOSED;
        notifyClosedQuestion();
        touch();
    }

    public void reopen() {
        this.status = QuestionStatus.ACTIVE;
        touch();
    }

    public void markDeleted() { /* soft delete */ }

    public void restore() { /* restore */ }

    public void incrementViewCount() {
        viewCount++;
    }

    private void touch() {
        this.modificationDate = LocalDateTime.now();
    }
}
