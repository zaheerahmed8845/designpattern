package org.example.strategy;

import org.example.entity.Player;

public class BatsmanStrategy implements PlayerRoleStrategy {
    @Override
    public String perform(Player p) {
        return p.name + " focuses on strike rotation and boundary options.";
    }
}
