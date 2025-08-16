package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private byte[] profilePicture;
    private List<byte[]> coverPhotos = new ArrayList<>();
    private String headline;
    private String about;
    private String gender;
    private List<Experience> experiences = new ArrayList<>();
    private List<Education> education = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    private List<Achievement> achievements = new ArrayList<>();
    private List<Recommendation> recommendations = new ArrayList<>();
    private Analytics analytics = new Analytics();

    public void addExperience(Experience e) {
        experiences.add(e);
    }

    public void addEducation(Education e) {
        education.add(e);
    }

    public void addSkill(Skill s) {
        skills.add(s);
    }

    public void addAchievement(Achievement a) {
        achievements.add(a);
    }

    public void addRecommendation(Recommendation r) {
        recommendations.add(r);
    }

    public Analytics getAnalytics() {
        return analytics;
    }
}
