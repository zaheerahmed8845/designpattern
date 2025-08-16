package org.example.match;

import org.example.entity.Playing11;
import org.example.entity.Stadium;
import org.example.entity.Team;

import java.time.LocalDateTime;

public class MatchBuilder {
    private final MatchFactory.Type type;
    private Team home, away;
    private Stadium stadium;
    private LocalDateTime start;
    private Playing11 homeXI, awayXI;

    public MatchBuilder(MatchFactory.Type type) {
        this.type = type;
    }

    public MatchBuilder teams(Team home, Team away) {
        this.home = home;
        this.away = away;
        return this;
    }

    public MatchBuilder stadium(Stadium s) {
        this.stadium = s;
        return this;
    }

    public MatchBuilder start(LocalDateTime t) {
        this.start = t;
        return this;
    }

    public MatchBuilder playing11(Playing11 homeXI, Playing11 awayXI) {
        this.homeXI = homeXI;
        this.awayXI = awayXI;
        return this;
    }

    public Match build() {
        Match match = new MatchFactory().create(type);
        match.home = home;
        match.away = away;
        match.stadium = stadium;
        match.startTime = start;
        if (homeXI != null) match.playingHome = homeXI;
        if (awayXI != null) match.playingAway = awayXI;
        return match;
    }
}
