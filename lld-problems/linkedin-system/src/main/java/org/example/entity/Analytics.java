package org.example.entity;

public class Analytics {
    private int searchAppearances;
    private int profileViews;
    private int postImpressions;
    private int totalConnections;

    public void incSearchAppearances() {
        searchAppearances++;
    }

    public void incProfileViews() {
        profileViews++;
    }

    public void incPostImpressions() {
        postImpressions++;
    }

    public void setTotalConnections(int total) {
        this.totalConnections = total;
    }

    @Override
    public String toString() {
        return "Analytics{search=" + searchAppearances + ", profileViews=" + profileViews +
                ", postImpressions=" + postImpressions + ", connections=" + totalConnections + "}";
    }
}
