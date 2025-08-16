package org.example.entity;

import org.example.stats.TeamStat;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public String name;
    public List<Player> players = new ArrayList<>();
    public Coach coach;
    public TeamStat teamStat = new TeamStat();
    public List<News> news = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void addNews(News n) {
        news.add(n);
    }
}
