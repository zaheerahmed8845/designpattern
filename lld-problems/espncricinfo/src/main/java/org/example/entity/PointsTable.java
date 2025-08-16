package org.example.entity;

import org.example.match.Match;

import java.util.LinkedHashMap;
import java.util.Map;

public class PointsTable {
    public Map<Team, Integer> teamPoints = new LinkedHashMap<>();
    public Map<Match, String> matchResults = new LinkedHashMap<>(); // simple note

    public void addPoints(Team t, int pts) {
        teamPoints.merge(t, pts, Integer::sum);
    }
}