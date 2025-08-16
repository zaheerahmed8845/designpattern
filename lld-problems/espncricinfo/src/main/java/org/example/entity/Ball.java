package org.example.entity;

import org.example.enums.BallType;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    public Player balledBy;
    public Player playedBy;
    public BallType type = BallType.NORMAL;
    public Wicket wicket;
    public List<Run> runs = new ArrayList<>();

    public int runsScored() {
        return runs.stream().mapToInt(r -> r.totalRuns).sum();
    }
}
