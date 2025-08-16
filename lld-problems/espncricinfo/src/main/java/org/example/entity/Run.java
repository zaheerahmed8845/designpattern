package org.example.entity;

import org.example.enums.RunType;

public class Run {
    public int totalRuns;
    public RunType type = RunType.NORMAL;
    public Player scoredBy;

    public Run(int totalRuns, RunType type, Player by) {
        this.totalRuns = totalRuns;
        this.type = type;
        this.scoredBy = by;
    }
}
