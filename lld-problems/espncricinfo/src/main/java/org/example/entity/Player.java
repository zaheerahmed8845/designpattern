package org.example.entity;

import org.example.enums.PlayingPosition;
import org.example.strategy.AllRounderStrategy;
import org.example.strategy.BatsmanStrategy;
import org.example.strategy.BowlerStrategy;
import org.example.strategy.PlayerRoleStrategy;

public class Player {
    public String name;
    public int age;
    public String country;
    public PlayingPosition position;

    // Strategy Pattern: behavior varies by role
    private PlayerRoleStrategy roleStrategy;

    public Player(String name, int age, String country, PlayingPosition pos) {
        this.name = name;
        this.age = age;
        this.country = country;
        setPosition(pos);
    }

    public void setPosition(PlayingPosition pos) {
        this.position = pos;
        switch (pos) {
            case BATSMAN -> roleStrategy = new BatsmanStrategy();
            case BOWLER -> roleStrategy = new BowlerStrategy();
            case ALL_ROUNDER, WICKET_KEEPER -> roleStrategy = new AllRounderStrategy();
        }
    }

    public String performRole() {
        return roleStrategy.perform(this);
    }
}
