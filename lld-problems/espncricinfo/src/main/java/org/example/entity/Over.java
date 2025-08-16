package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Over {
    public int number;
    public Player bowler;
    public List<Ball> balls = new ArrayList<>();

    public Over(int number, Player bowler) {
        this.number = number;
        this.bowler = bowler;
    }

    public void addBall(Ball b) {
        balls.add(b);
    }

    public int totalRuns() {
        return balls.stream().mapToInt(Ball::runsScored).sum();
    }
}
