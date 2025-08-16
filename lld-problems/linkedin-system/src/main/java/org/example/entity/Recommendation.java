package org.example.entity;

import java.time.LocalDateTime;

public class Recommendation {
    private int userId;
    private LocalDateTime createdOn = LocalDateTime.now();
    private String description;
    private boolean accepted;

    public Recommendation(int userId, String description) {
        this.userId = userId;
        this.description = description;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void accept() {
        this.accepted = true;
    }

    @Override
    public String toString() {
        return "Recommendation{" + description + ", accepted=" + accepted + "}";
    }
}
