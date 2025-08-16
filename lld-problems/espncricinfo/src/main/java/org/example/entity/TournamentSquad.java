package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class TournamentSquad {
    public Tournament tournament;
    public Team team;
    public List<Player> players = new ArrayList<>();

    public TournamentSquad(Tournament t, Team team) {
        this.tournament = t;
        this.team = team;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }
}
