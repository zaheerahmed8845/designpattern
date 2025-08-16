package org.example.entity;

import org.example.match.Match;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    public String name;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public List<Team> teams = new ArrayList<>();
    public List<Match> matches = new ArrayList<>();
    public PointsTable pointsTable = new PointsTable();

    public Tournament(String name) {
        this.name = name;
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public void addMatch(Match m) {
        matches.add(m);
    }
}
