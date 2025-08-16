package org.example.entity;

import org.example.enums.Polarity;

public class Edge {
    private final int profileId;
    private final Polarity polarity;

    public Edge(int profileId, Polarity polarity) {
        this.profileId = profileId;
        this.polarity = polarity;
    }

    public int getProfileId() {
        return profileId;
    }

    public Polarity getPolarity() {
        return polarity;
    }
}
