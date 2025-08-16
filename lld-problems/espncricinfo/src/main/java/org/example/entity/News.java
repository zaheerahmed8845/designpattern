package org.example.entity;

import org.example.match.Match;

import java.time.LocalDateTime;

public class News {
    public LocalDateTime date = LocalDateTime.now();
    public String text;
    public String image;
    public Team team;
    public Player player;
    public Match match;

    public News(String text) {
        this.text = text;
    }
}
