package org.example.entity;

import org.example.match.Match;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private static final Admin INSTANCE = new Admin();

    private Admin() {
    }

    public static Admin getInstance() {
        return INSTANCE;
    }

    public final List<Player> players = new ArrayList<>();
    public final List<Team> teams = new ArrayList<>();
    public final List<Tournament> tournaments = new ArrayList<>();
    public final List<Match> matches = new ArrayList<>();
    public final List<News> news = new ArrayList<>();

    public boolean addTeam(Team t) {
        return teams.add(t);
    }

    public boolean addPlayer(Player p) {
        return players.add(p);
    }

    public boolean addTournament(Tournament t) {
        return tournaments.add(t);
    }

    public boolean addMatch(Match m) {
        return matches.add(m);
    }

    public boolean addNews(News n) {
        return news.add(n);
    }
}
