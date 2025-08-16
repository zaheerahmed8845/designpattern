package org.example.strategy;

import org.example.entity.Player;

public class BowlerStrategy implements PlayerRoleStrategy {
    @Override
    public String perform(Player p) {
        return p.name + " varies line/length and uses slower balls at death.";
    }
}
