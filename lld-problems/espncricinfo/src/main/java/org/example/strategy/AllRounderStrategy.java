package org.example.strategy;

import org.example.entity.Player;

public class AllRounderStrategy implements PlayerRoleStrategy {
    @Override
    public String perform(Player p) {
        return p.name + " contributes with bat and ball as per match situation.";
    }
}
