package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bounty {
    private final int reputationPoints;
    private final LocalDateTime expiryDate;
    private Question question;

    public Bounty(int reputationPoints, LocalDateTime expiryDate) {
        this.reputationPoints = Math.max(0, reputationPoints);
        this.expiryDate = Objects.requireNonNull(expiryDate);
    }

    public int getReputationPoints() {
        return reputationPoints;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question q) {
        this.question = q;
    }

    public void updateReputationPoints() { /* placeholder */ }
}
