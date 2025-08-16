package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Playing11 {
    public List<Player> players = new ArrayList<>();

    public void addPlayer(Player p) {
        if (players.size() < 11) players.add(p);
    }
}
